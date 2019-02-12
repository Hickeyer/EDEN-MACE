/**
 * 垂直升级配置管理初始化
 */
var DisUpgradeParam = {
    id: "DisUpgradeParamTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DisUpgradeParam.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
        {title: '名称', field: 'upgradeName', visible: true, align: 'center', valign: 'middle'},
        {title: '开始积分', field: 'beginIntegral', visible: true, align: 'center', valign: 'middle'},
        {title: '结束积分', field: 'endIntegral', visible: true, align: 'center', valign: 'middle'},
        {title: '垂直等级', field: 'disUserRank', visible: true, align: 'center', valign: 'middle'},
        {title: '添加时间', field: 'addTime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
DisUpgradeParam.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DisUpgradeParam.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加垂直升级配置
 */
DisUpgradeParam.openAddDisUpgradeParam = function () {
    var index = layer.open({
        type: 2,
        title: '添加垂直升级配置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/DisUpgradeParam/DisUpgradeParam_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看垂直升级配置详情
 */
DisUpgradeParam.openDisUpgradeParamDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '垂直升级配置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/DisUpgradeParam/DisUpgradeParam_update/' + DisUpgradeParam.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除垂直升级配置
 */
DisUpgradeParam.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/DisUpgradeParam/delete", function (data) {
            Feng.success("删除成功!");
            DisUpgradeParam.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询垂直升级配置列表
 */
DisUpgradeParam.search = function () {
    var queryData = {};
    queryData['upgradeName'] = $("#upgradeName").val();
    DisUpgradeParam.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DisUpgradeParam.initColumn();
    var table = new BSTable(DisUpgradeParam.id, "/DisUpgradeParam/list", defaultColunms);
    table.setPaginationType("client");
    DisUpgradeParam.table = table.init();
});
