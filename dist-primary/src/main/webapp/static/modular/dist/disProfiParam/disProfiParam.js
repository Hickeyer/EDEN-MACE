/**
 * 参数设置管理初始化
 */
var DisProfiParam = {
    id: "DisProfiParamTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DisProfiParam.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '平台id', field: 'disPlatformId', visible: true, align: 'center', valign: 'middle'},
        {title: '计算模型', field: 'calModel', visible: true, align: 'center', valign: 'middle'},
        {title: '账户类型', field: 'accountType', visible: true, align: 'center', valign: 'middle'},
        {title: '分润值', field: 'disProValue', visible: true, align: 'center', valign: 'middle'},
        {title: '分润级别', field: 'disProLevel', visible: true, align: 'center', valign: 'middle'},
        {title: '用户类型', field: 'disUserType', visible: true, align: 'center', valign: 'middle'},
        {title: '用户段位', field: 'disUserRankDetail', visible: true, align: 'center', valign: 'middle'},
        {title: '添加时间', field: 'addTime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
DisProfiParam.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DisProfiParam.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加参数设置
 */
DisProfiParam.openAddDisProfiParam = function () {

    var index = layer.open({
        type: 2,
        title: '会员分润设置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/disProfiParam/disProfiParam_add'
    });
    this.layerIndex = index;
};
DisProfiParam.openAddPlatDisProfiParam = function () {
    var index = layer.open({
        type: 2,
        title: '平台分润设置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/disProfiParam/disProfiParam_add_plat'
    });
    this.layerIndex = index;
};
/**
 * 打开查看参数设置详情
 */
DisProfiParam.openDisProfiParamDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '参数设置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/disProfiParam/disProfiParam_update/' + DisProfiParam.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除参数设置
 */
DisProfiParam.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/disProfiParam/delete", function (data) {
            Feng.success("删除成功!");
            DisProfiParam.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询参数设置列表
 */
DisProfiParam.search = function () {
    DisProfiParam.table.refresh({query: DisProfiParam.formParams()});
};
DisProfiParam.formParams = function() {
    var queryData = {};
    queryData['calModel'] = $("#calModel").val();
    queryData['accountType'] = $("#accountType").val();
    queryData['disUserType'] = $("#disUserType").val();
    queryData['disUserRank'] = $("#disUserRank").val();
    return queryData;
}
$(function () {
    var defaultColunms = DisProfiParam.initColumn();
    var table = new BSTable(DisProfiParam.id, "/disProfiParam/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(DisProfiParam.formParams());
    DisProfiParam.table = table.init();
});
