/**
 * 模拟菜单管理初始化
 */
var SimOper = {
    id: "SimOperTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SimOper.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
SimOper.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SimOper.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加模拟菜单
 */
SimOper.openMemberAdd = function () {
    var index = layer.open({
        type: 2,
        title: '模拟添加会员',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/simOper/member_add'
    });
    this.layerIndex = index;
};
SimOper.openOrderAdd = function () {
    var index = layer.open({
        type: 2,
        title: '模拟交易',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/simOper/order_add'
    });
    this.layerIndex = index;
};

SimOper.openLevelAdd = function () {
    var index = layer.open({
        type: 2,
        title: '模拟升级',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/simOper/level_add'
    });
    this.layerIndex = index;
};
SimOper.openWithdrawAdd = function () {
    var index = layer.open({
        type: 2,
        title: '模拟提现',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/simOper/withdraw_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看模拟菜单详情
 */
SimOper.openSimOperDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '模拟菜单详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/simOper/simOper_update/' + SimOper.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除模拟菜单
 */
SimOper.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/simOper/delete", function (data) {
            Feng.success("删除成功!");
            SimOper.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("simOperId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询模拟菜单列表
 */
SimOper.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    SimOper.table.refresh({query: queryData});
};
SimOper.clearData = function () {
    var ajax = new $ax(Feng.ctxPath + "/clearData", function(data){
        Feng.success("数据清理成功!");
    },function(data){
        Feng.error("清理失败!" + data.responseJSON.message + "!");
    });
    ajax.start();
};

$(function () {

});
