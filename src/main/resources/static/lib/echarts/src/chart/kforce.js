/**
 * echarts图表类：力导向图
 *
 * @author pissang (https://github.com/pissang/)
 *
 */

define(function(require) {
    'use strict';
    /**
     * 构造函数
     * @param {Object} messageCenter echart消息中心
     * @param {ZRender} zr zrender实例
     * @param {Object} series 数据
     * @param {Object} component 组件
     */
    function KForce(messageCenter, zr, option, component) {
        // 基类装饰
        var ComponentBase = require('../component/base');
        ComponentBase.call(this, zr);
        // 可计算特性装饰
        var CalculableBase = require('./calculableBase');
        CalculableBase.call(this, zr, option);

        var ecConfig = require('../config');
        var ecData = require('../util/ecData');

        var zrConfig = require('zrender/config');
        var zrEvent = require('zrender/tool/event');
        // var zrColor = require('zrender/tool/color');
        var zrUtil = require('zrender/tool/util');
        var vec2 = require('zrender/tool/vector');

        var NDArray = require('../util/ndarray');

        var self = this;
        self.type = ecConfig.CHART_TYPE_KFORCE;

        var series;

        var forceSerie;

        var nodeShapes = [];
        var linkShapes = [];

        // 节点分类
        var categories = [];
        // 默认节点样式
        var nodeStyle;
        var nodeEmphasisStyle;
        // 默认边样式
        var linkStyle;
        var linkEmphasisStyle;

        var rawNodes;
        var rawLinks;

        // nodes和links的原始数据
        var nodesRawData = [];
        var linksRawData = [];

        // nodes和links的权重, 用来计算引力和斥力
        var nodeWeights = [];
        var linkWeights = [];

        // 节点的受力
        var nodeForces = [];
        // 节点的加速度
        var nodeAccelerations = [];
        // 节点的位置
        var nodePositions = [];
        var nodePrePositions = [];
        // 节点的质量
        var nodeMasses = [];

        var temperature;
        var k;
        
        //- ----------外部参数
        var density;
        var initSize;
        var coolDown;
        var centripetal;
        // var initializeSize; // defined but never used
        var attractiveness;
        //- ----------

        var stepTime = 1/60;
        
        var viewportWidth;
        var viewportHeight;
        var centroid = [];

        var mouseX, mouseY;
        //zhao 
        var Oy = 0;
        var Ox = 0;
        var dy = 0;
        var dx = 0;
        var isShowScrollBar =true;

        function _buildShape() {
            var legend = component.legend;
            temperature = 1.0;
            viewportWidth = zr.getWidth();
            viewportHeight = zr.getHeight();
            centroid = [viewportWidth/2, viewportHeight/2];

            for (var i = 0, l = series.length; i < l; i++) {
                var serie = series[i];
                if (serie.type === ecConfig.CHART_TYPE_KFORCE) {
                    series[i] = self.reformOption(series[i]);
                    forceSerie = serie;

                    var minRadius = self.deepQuery([serie], 'minRadius');
                    var maxRadius = self.deepQuery([serie], 'maxRadius');

                    // ----------获取外部参数
                    attractiveness = self.deepQuery(
                        [serie], 'attractiveness'
                    );
                    density = self.deepQuery([serie], 'density');
                    initSize = self.deepQuery([serie], 'initSize');
                    centripetal = self.deepQuery([serie], 'centripetal');
                    coolDown = self.deepQuery([serie], 'coolDown');
                    // ----------

                    categories = self.deepQuery([serie], 'categories');
                    
                    // 同步selected状态
                    for (var j = 0, len = categories.length; j < len; j++) {
                        if (categories[j].name) {
                            if (legend){
                                self.selectedMap[j] = 
                                    legend.isSelected(categories[j].name);
                            } else {
                                self.selectedMap[j] = true;
                            }
                        }
                    }

                    linkStyle = self.deepQuery(
                        [serie], 'itemStyle.normal.linkStyle'
                    );
                    linkEmphasisStyle = self.deepQuery(
                        [serie], 'itemStyle.emphasis.linkStyle'
                    );
                    nodeStyle = self.deepQuery(
                        [serie], 'itemStyle.normal.nodeStyle'
                    );
                    nodeEmphasisStyle = self.deepQuery(
                        [serie], 'itemStyle.emphasis.nodeStyle'
                    );
                    
                    rawNodes = self.deepQuery([serie], 'nodes');
                    rawLinks = zrUtil.clone(self.deepQuery([serie], 'links'));
                    _filterData(
                        zrUtil.clone(self.deepQuery([serie], 'nodes')),
                        zrUtil.clone(self.deepQuery([serie], 'links'))
                    );
                    // Reset data
                    nodePositions = [];
                    nodePrePositions = [];
                    nodeMasses = [];
                    nodeWeights = [];
                    linkWeights = [];
                    nodeMasses = [];
                    nodeShapes = [];
                    linkShapes = [];

                    var area = viewportWidth * viewportHeight;

                    // Formula in 'Graph Drawing by Force-directed Placement'
                    k = 0.5 / attractiveness 
                        * Math.sqrt( area / nodesRawData.length );
                    
                    // 这两方法里需要加上读取self.selectedMap判断当前系列是否显示的逻辑
                    _buildLinkShapes(nodesRawData, linksRawData);
                    _buildNodeShapes(nodesRawData, minRadius, maxRadius);
                }
            }
        }

        function _filterData(nodes, links) {
            var filteredNodeMap = [];
            var cursor = 0;
            nodesRawData = _filter(nodes, function(node, idx) {
                if(!node){
                    return;
                }
                if (self.selectedMap[node.category]) {
                    filteredNodeMap[idx] = cursor++;
                    return true;
                }else{
                    filteredNodeMap[idx] = -1;
                }
            });
            var source;
            var target;
            var ret;
            linksRawData = _filter(links, function(link/*, idx*/){
                source = link.source;
                target = link.target;
                ret = true;
                if (filteredNodeMap[source] >= 0) {
                    link.source = filteredNodeMap[source];
                } else {
                    ret = false;
                }
                if (filteredNodeMap[target] >= 0) {
                    link.target = filteredNodeMap[target];
                } else {
                    ret = false;
                }

                return ret;
            });
        }
        //zhao
        function _buildScrollBar() {
            var barPosition = [];
            barPosition[0] = (zr.getWidth() / 2 - 50);
            barPosition[1] = (zr.getHeight() / 2 - 50);
            Ox = barPosition[0];
            Oy = barPosition[1];
            var vscrollArea = {
                shape:'rectangle',
                id:'vscrollArea',
                style: {
                    x: zr.getWidth()-20,
                    y: 10,
                    width: 20,
                    height: zr.getHeight() - 30,
                    color: 'gray',
                    opacity: 0.3
                }
            };
            var vscroll = {
                shape:'rectangle',
                id:'vscroll',
                style:{
                    x: zr.getWidth() - 20,
                    y: barPosition[1],
                    width: 20,
                    height: 50,
                    color:'#5BB1E4'
                },
                draggable : true,
                ondrift : function(shape, dx, dy) {
                    shape.style.y += dy;
                    if(shape.style.y < 10) 
                        shape.style.y = 10
                    else if (shape.style.y > zr.getHeight() - 70 ) // 80 = 50 + 40 - 10
                        shape.style.y = zr.getHeight() - 70;
                    zr.modShape(shape.id, shape);
                    zr.refresh();
                    return true;
                },
                ondragstart: function(params) {
                    var shape = params.target;
                    temperature = 0.001 //拖动滚动条时图不动 
                },
                ondragend  : function(params) {
                    var shape = params.target;
                    self.clear();
                    _buildShape();
                    temperature = 1.0;
                    dy = (shape.style.y - Oy)*2; 
                    for(var i in nodeShapes){
                        nodeShapes[i].style.y -= dy;
                        nodeShapes[i].style.x -= dx;
                    }
                    _step();
                    return true;
                }   
            };
            var hscrollArea = {
                shape: 'rectangle',
                id: 'hscrollArea',
                    style: {
                        x: 10,
                        y: zr.getHeight() - 20,
                        width: zr.getWidth() - 30,
                        height: 20,
                        color: 'gray',
                        opacity: 0.3
                }
            };
            var hscroll = {
                shape:'rectangle',
                id:'hscroll',
                style : {
                    x: barPosition[0],
                    y: zr.getHeight() - 20,
                    width: 50,
                    height: 20,
                    color: '#5BB1E4'
                },
                draggable : true,
                ondrift : function(shape, dx, dy) {
                    shape.style.x += dx;
                    if(shape.style.x < 10) 
                        shape.style.x = 10
                    else if (shape.style.x > zr.getWidth() - 70 ) 
                        shape.style.x = zr.getWidth() - 70;
                    zr.modShape(shape.id, shape);
                    zr.refresh();
                    return true;
                },
                ondragstart: function(params) {
                    var shape = params.target;
                    temperature = 0.001 //拖动滚动条时图不动 
                },
                ondragend  : function(params) {
                    var shape = params.target;
                    self.clear();
                    _buildShape();
                    temperature = 1.0;
                    dx = (shape.style.x - Ox)*2; 
                    for(var i in nodeShapes){
                        nodeShapes[i].style.x -= dx;
                        nodeShapes[i].style.y -= dy;
                    }
                    _step();
                    return true;
                }   
            };
            zr.addShape(vscrollArea);
            zr.addShape(vscroll);
            zr.addShape(hscrollArea);
            zr.addShape(hscroll);
        }
        function _restoreScrollBar(){
            dx = 0;
            dy = 0;
            zr.modShape('vscroll',{style:{x: zr.getWidth() - 20,y: 10}});
            zr.modShape('hscroll',{style:{x: 10,y: zr.getHeight() - 20,}});
            zr.refresh();
        }
        function _buildNodeShapes(nodes, minRadius, maxRadius) {
            // 将值映射到minRadius-maxRadius的范围上
            var radius = [];
            var l = nodes.length;
            for (var i = 0; i < l; i++) {
                var node = nodes[i];
                radius.push(node.value);
            }

            var narr = new NDArray(radius);
            radius = narr.map(minRadius, maxRadius)
                        .toArray();
            var max = narr.max();
            if (max !== 0) {
                nodeWeights = narr.mul(1/max, narr).toArray();
            }

            for (var i = 0; i < l; i++) {
                var node = nodes[i];
                var x, y;
                var r = radius[i];

                var random = _randomInSquare(
                    viewportWidth/2, viewportHeight/2, initSize
                );
                x = typeof(node.initial) === 'undefined' 
                    ? random.x
                    : node.initial.x;
                y = typeof(node.initial) === 'undefined'
                    ? random.y
                    : node.initial.y;
                //zhaoyebin 2013/12/9 shape自定义 shapeType : circle ,polygon... 
                var spType = 'circle';               
                var spStyle = {
                        r : r,
                        x : 0,
                        y : 0
                 };
                //node 节点形状
                if(typeof(node.shapeType) !== 'undefined'){
                    var sptype =  node.shapeType;
                    if(sptype) {
                        spType = sptype;
                        if(spType ==='rectangle')
                        {   
                            //默认矩形长宽
                            spStyle = {width:2*r,height:2*r,x:0,y:0};
                        }
                        if(spType ==='ellipse')
                        {
                            spStyle = {a:2*r,b:r,x:0,y:0};
                        }
                    }
                }
                var shape = {
                    id : zr.newShapeId(self.type),
                    shape : spType,
                    style : spStyle,
                    highlightStyle : {},
                    position : [x, y],
                    clickable : true,                   
                    __forceIndex : i
                };
                /////////////////////////////////////////////////////////////////////
                // 初始化位置
                nodePositions[i] = [x, y];
                nodePrePositions[i] = [x, y];
                // 初始化受力
                nodeForces[i] = [0, 0];
                // 初始化加速度
                nodeAccelerations[i] = [0, 0];
                // 初始化质量
                nodeMasses[i] = r * r * density * 0.035;

                
                // Label 
                var labelStyle;
                if (self.deepQuery([forceSerie], 'itemStyle.normal.label.show')
                ) {
                    shape.style.text = node.name;
                    shape.style.textPosition = 'inside';
                    labelStyle = self.deepQuery(
                        [forceSerie], 'itemStyle.normal.label.textStyle'
                    ) || {};
                    shape.style.textColor = labelStyle.color || '#fff';
                    shape.style.textAlign = labelStyle.align || 'center';
                    shape.style.textBaseLine = labelStyle.baseline || 'middle';
                    shape.style.textFont = self.getFont(labelStyle);
                }

                if (self.deepQuery(
                        [forceSerie], 'itemStyle.emphasis.label.show'
                    )
                ) {
                    shape.highlightStyle.text = node.name;
                    shape.highlightStyle.textPosition = 'inside';
                    labelStyle = self.deepQuery(
                        [forceSerie], 'itemStyle.emphasis.label.textStyle'
                    ) || {};
                    shape.highlightStyle.textColor = labelStyle.color || '#fff';
                    shape.highlightStyle.textAlign = labelStyle.align 
                                                     || 'center';
                    shape.highlightStyle.textBaseLine = labelStyle.baseline 
                                                        || 'middle';
                    shape.highlightStyle.textFont = self.getFont(labelStyle);
                }

                // 优先级 node.style > category.style > defaultStyle
                zrUtil.merge(shape.style, nodeStyle);
                zrUtil.merge(shape.highlightStyle, nodeEmphasisStyle);

                if (typeof(node.category) !== 'undefined') {
                    var category = categories[node.category];
                    if (category) {
                        var style = category.itemStyle;
                        if (style) {
                            if (style.normal) {
                                zrUtil.merge(shape.style, style.normal, {
                                    overwrite : true
                                });
                            }
                            if (style.emphasis) {
                                zrUtil.merge(
                                    shape.highlightStyle, 
                                    style.emphasis, 
                                    { overwrite : true }
                                );
                            }
                        }
                    }
                }
                if (typeof(node.itemStyle) !== 'undefined') {
                    var style = node.itemStyle;
                    if( style.normal ){ 
                        zrUtil.merge(shape.style, style.normal, {
                            overwrite : true
                        });
                    }
                    if( style.normal ){ 
                        zrUtil.merge(shape.highlightStyle, style.emphasis, {
                            overwrite : true
                        });
                    }
                }
                //自定义事件
                if(typeof(node.onclick) !== 'undefined'){
                    if(node.onclick) {
                        shape.clickable = true;
                        shape.onclick = node.onclick;
                    }
                }
                //拖拽特性
                self.setCalculable(shape);
                shape.ondragstart = self.shapeHandler.ondragstart;
                shape.draggable = true;
                
                nodeShapes.push(shape);
                self.shapeList.push(shape);

                var categoryName = '';
                if (typeof(node.category) !== 'undefined') {
                    var category = categories[node.category];
                    categoryName = (category && category.name) || '';
                }
                // !!Pack data before addShape
                ecData.pack(
                    shape,
                    // category
                    {
                        name : categoryName
                    },
                    // series index
                    0,
                    // data
                    node,
                    // data index
                    rawNodes.indexOf(node),
                    // name
                    node.name || '',
                    // value
                    node.value
                );
                zr.addShape(shape);
            }
            // _normalize(nodeMasses, nodeMasses);
        }

        function _buildLinkShapes(nodes, links) {
            var l = links.length;

            for (var i = 0; i < l; i++) {
                var link = links[i];
                //var source = nodes[link.source];
                // var target = nodes[link.target];
                var weight = link.weight || 1;
                linkWeights.push(weight);

                var shape = {
                    id : zr.newShapeId(self.type),
                    shape : 'line',
                    hoverable : false,
                    style : {
                        xStart : 0,
                        yStart : 0,
                        xEnd : 0,
                        yEnd : 0
                    },
                    clickable : true,
                    highlightStyle : {}
                };

                zrUtil.merge(shape.style, linkStyle);
                zrUtil.merge(shape.highlightStyle, linkEmphasisStyle);
                //优先级 ItemStyle > linkStyle 
                if (typeof(link.itemStyle) !== 'undefined') {
                    if(link.itemStyle.normal){
                        zrUtil.merge(shape.style, link.itemStyle.normal, {
                            overwrite : true
                        });
                    }
                    if(link.itemStyle.emphasis){
                        zrUtil.merge(
                            shape.highlightStyle, 
                            link.itemStyle.emphasis, 
                            { overwrite : true }
                        );
                    }
                }
                //zhao
                if (typeof (link.onclick) !== 'undefined') {
                    if (link.onclick) {
                        shape.onclick = link.onclick;
                    }
                }
                linkShapes.push(shape);
                self.shapeList.push(shape);

                zr.addShape(shape);
            }

            var narr = new NDArray(linkWeights);
            var max = narr.max();
            if (max !== 0) {
                linkWeights = narr.mul(1/max, narr).toArray();
            }
        }

        function _updateLinkShapes(){
            for (var i = 0, l = linksRawData.length; i < l; i++) {
                var link = linksRawData[i];
                var linkShape = linkShapes[i];
                var sourceShape = nodeShapes[link.source];
                var targetShape = nodeShapes[link.target];
                //zhaoyebin 2013/12/10 调整Link连接位置
                var sourceAjust = [0,0];
                var targetAjust = [0,0];
                if(sourceShape.shape === 'rectangle') {
                    sourceAjust[0] = sourceShape.style.width / 2;
                    sourceAjust[1] = sourceShape.style.height / 2;
                }
                if(targetShape.shape === 'rectangle') {
                    targetAjust[0] = targetShape.style.width / 2;
                    targetAjust[1] = targetShape.style.height / 2;
                }
                linkShape.style.xStart = sourceShape.position[0] + sourceAjust[0] - dx;
                linkShape.style.yStart = sourceShape.position[1] + sourceAjust[1] - dy;
                linkShape.style.xEnd = targetShape.position[0] + targetAjust[0] - dx;
                linkShape.style.yEnd = targetShape.position[1] + targetAjust[1] - dy;
            }
        }

        function _update(stepTime) {
            var len = nodePositions.length;
            var v12 = [];
            // 计算节点之间斥力
            var k2 = k*k;
            // Reset force
            for (var i = 0; i < len; i++) {
                nodeForces[i][0] = 0;
                nodeForces[i][1] = 0;
            }
            for (var i = 0; i < len; i++) {
                for (var j = i+1; j < len; j++){
                    var w1 = nodeWeights[i];
                    var w2 = nodeWeights[j];
                    var p1 = nodePositions[i];
                    var p2 = nodePositions[j];

                    // 节点1到2的向量
                    vec2.sub(v12, p2, p1);
                    var d = vec2.length(v12);
                    // 距离大于500忽略斥力
                    if(d > 500){
                        continue;
                    }
                    if(d < 5){
                        d = 5;
                    }

                    vec2.scale(v12, v12, 1/d);
                    var forceFactor = 1 * (w1 + w2) * k2 / d;

                    vec2.scale(v12, v12, forceFactor);
                    //节点1受到的力
                    vec2.sub(nodeForces[i], nodeForces[i], v12);
                    //节点2受到的力
                    vec2.add(nodeForces[j], nodeForces[j], v12);
                }
            }
            // 计算节点之间引力
            for (var i = 0, l = linksRawData.length; i < l; i++) {
                var link = linksRawData[i];
                var w = linkWeights[i];
                var s = link.source;
                var t = link.target;
                var p1 = nodePositions[s];
                var p2 = nodePositions[t];

                vec2.sub(v12, p2, p1);
                var d2 = vec2.lengthSquare(v12);
                vec2.normalize(v12, v12);

                var forceFactor = w * d2 / k;
                // 节点1受到的力
                vec2.scale(v12, v12, forceFactor);
                vec2.add(nodeForces[s], nodeForces[s], v12);
                // 节点2受到的力
                vec2.sub(nodeForces[t], nodeForces[t], v12);
            }
            // 到质心的向心力
            for (var i = 0, l = nodesRawData.length; i < l; i++){
                var p = nodePositions[i];
                vec2.sub(v12, centroid, p);
                var d2 = vec2.lengthSquare(v12);
                vec2.normalize(v12, v12);
                // 100是可调参数
                var forceFactor = d2 / 100 * centripetal;
                vec2.scale(v12, v12, forceFactor);
                vec2.add(nodeForces[i], nodeForces[i], v12);

            }
            // 计算加速度
            for (var i = 0, l = nodeAccelerations.length; i < l; i++) {
                vec2.scale(
                    nodeAccelerations[i], nodeForces[i], 1 / nodeMasses[i]
                );
            }
            var velocity = [];
            var tmp = [];
            // 计算位置(verlet积分)
            for (var i = 0, l = nodePositions.length; i < l; i++) {
                if (nodesRawData[i].fixed) {
                    // 拖拽同步
                    nodePositions[i][0] = mouseX + dx;
                    nodePositions[i][1] = mouseY + dy;
                    nodePrePositions[i][0] = mouseX + dx;
                    nodePrePositions[i][1] = mouseY + dy;
                    nodeShapes[i].position[0] = mouseX + dx;
                    nodeShapes[i].position[1] = mouseY + dy;
                    continue;
                }
                var p = nodePositions[i];
                var __P = nodePrePositions[i];
                vec2.sub(velocity, p, __P);
                __P[0] = p[0];
                __P[1] = p[1];
                vec2.add(
                    velocity, 
                    velocity, 
                    vec2.scale(tmp, nodeAccelerations[i], stepTime)
                );
                // Damping
                vec2.scale(velocity, velocity, temperature);
                // 防止速度太大
                velocity[0] = Math.max(Math.min(velocity[0], 100), -100);
                velocity[1] = Math.max(Math.min(velocity[1], 100), -100);

                vec2.add(p, p, velocity);
                nodeShapes[i].position[0] = p[0] ;
                nodeShapes[i].position[1] = p[1] ;

                if(isNaN(p[0]) || isNaN(p[1])){
                    throw new Error('NaN');
                }
            }
        }

        function _step(){
            if (temperature < 0.01) {
                return;
            }

            _update(stepTime);
            _updateLinkShapes();

            for (var i = 0; i < nodeShapes.length; i++) {
                var shape = nodeShapes[i];
                zr.modShape(shape.id, shape);
            }
            for (var i = 0; i < linkShapes.length; i++) {
                var shape = linkShapes[i];
                zr.modShape(shape.id, shape);
            }

            zr.refresh();

            // Cool Down
            temperature *= coolDown;
        }

        var _updating;

        function init(newOption, newComponent) {
            option = newOption;
            component = newComponent;

            series = option.series;

            self.clear();
            _buildShape();
            //zhao
            if(option.isShowScrollBar) _buildScrollBar();
                
            _updating = true;
            function cb() {
                if (_updating) {
                    _step();
                    setTimeout(cb, stepTime * 1000);
                }
            }
            
            setTimeout(cb, stepTime * 1000);
            //zhao
            //zr.on(zrConfig.EVENT.MOUSEWHEEL, _onmousewheel);
            
        }

        function refresh(newOption) {
            if (newOption) {
                option = newOption;
                series = option.series;
            }
            _restoreScrollBar();
            self.clear();
            _buildShape();
            temperature = 1.0;
        }

        function dispose(){
            _updating = false;
        }
        
        /**
         * 输出动态视觉引导线
         */
        self.shapeHandler.ondragstart = function() {
            self.isDragstart = true;
        };
        
        
        /**
         * 拖拽开始
         */
        function ondragstart(param) {
            if (!self.isDragstart || !param.target) {
                // 没有在当前实例上发生拖拽行为则直接返回
                return;
            }
            var shape = param.target;
            var idx = shape.__forceIndex;
            var node = nodesRawData[idx];
            node.fixed = true;
            // 处理完拖拽事件后复位
            self.isDragstart = false;
            zr.on(zrConfig.EVENT.MOUSEMOVE, _onmousemove);
        }
        /**         * 数据项被拖拽出去，重载基类方法
         */
        function ondragend(param, status) {
            if (!self.isDragend || !param.target) {
                // 没有在当前实例上发生拖拽行为则直接返回
                   
                return;
            }
            var shape = param.target;
            var idx = shape.__forceIndex;
            var node = nodesRawData[idx];
            node.fixed = false;
            // 别status = {}赋值啊！！
            status.dragIn = true;
            //你自己refresh的话把他设为false，设true就会重新调refresh接口
            status.needRefresh = false;

            // 处理完拖拽事件后复位
            self.isDragend = false;
            
            zr.un(zrConfig.EVENT.MOUSEMOVE, _onmousemove);
        }
        //zhao
        // 拖拽中位移信息
        function _onmousemove(param) {
                temperature = 0.8;
                mouseX = zrEvent.getX(param.event);
                mouseY = zrEvent.getY(param.event);  
        }
        //zhao
       
        
        self.init = init;
        self.refresh = refresh;
        self.ondragstart = ondragstart;
        self.ondragend = ondragend;
        self.dispose = dispose;

        init(option, component);
    }
    
    /*
    function _randomInCircle(x, y, radius) {
        var theta = Math.random() * Math.PI * 2;
        var r = radius * Math.random();
        return {
            x : Math.cos(theta) * r + x,
            y : Math.sin(theta) * r + y
        };
    }
    */
   
    function _randomInSquare(x, y, size) {
        return {
            x : (Math.random() - 0.5) * size + x,
            y : (Math.random() - 0.5) * size + y
        };
    }

    function _filter(array, callback){
        var len = array.length;
        var result = [];
        for(var i = 0; i < len; i++){
            if(callback(array[i], i)){
                result.push(array[i]);
            }
        }
        return result;
    }

    // 图表注册
    require('../chart').define('kforce', KForce);

    return KForce;
});