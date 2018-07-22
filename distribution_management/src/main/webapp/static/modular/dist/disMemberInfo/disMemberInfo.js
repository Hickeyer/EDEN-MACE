/**
 * 分销管理初始化
 */
var DisMemberInfo = {
    id: "DisMemberInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DisMemberInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '用户标识', field: 'disUserId', visible: true, align: 'center', valign: 'middle'},
        {title: '上级唯一标识', field: 'disModelId', visible: true, align: 'center', valign: 'middle'},
        {title: '用户名称', field: 'disUserName', visible: true, align: 'center', valign: 'middle'},
        {title: '用户级别', field: 'disLevel', visible: true, align: 'center', valign: 'middle'},
        {title: '用户类型', field: 'disUserType', visible: true, align: 'center', valign: 'middle'},
        {title: '用户段位', field: 'disUserRank', visible: true, align: 'center', valign: 'middle'},
        {title: '段位积分', field: 'rankIntegral', visible: true, align: 'center', valign: 'middle'},
        {title: '创建时间', field: 'addTime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
DisMemberInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DisMemberInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加分销
 */
DisMemberInfo.openAddDisMemberInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加分销',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/disMemberInfo/disMemberInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看分销详情
 */
DisMemberInfo.openDisMemberInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '分销详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/disMemberInfo/disMemberInfo_update/' + DisMemberInfo.seItem.id
        });
        this.layerIndex = index;
    }
};
DisMemberInfo.openDisMemberInfoView = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '分销详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/disMemberInfo/view/' + DisMemberInfo.seItem.disUserId
        });
        this.layerIndex = index;
    }
};

/**
 * 删除分销
 */
DisMemberInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/disMemberInfo/delete", function (data) {
            Feng.success("删除成功!");
            DisMemberInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("disMemberInfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询分销列表
 */
DisMemberInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DisMemberInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DisMemberInfo.initColumn();
    var table = new BSTable(DisMemberInfo.id, "/disMemberInfo/list", defaultColunms);
    table.setPaginationType("client");
    DisMemberInfo.table = table.init();
});
