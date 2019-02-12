/**
 * 段位积分管理初始化
 */
var DisRankParam = {
    id: "DisRankParamTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DisRankParam.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '名称', field: 'disRankName', visible: true, align: 'center', valign: 'middle'},
        {title: '平台id', field: 'disPlatformId', visible: true, align: 'center', valign: 'middle'},
        {title: '计算模型', field: 'calModel', visible: true, align: 'center', valign: 'middle'},
        {title: '账户类型', field: 'accountType', visible: true, align: 'center', valign: 'middle'},
        {title: '积分值', field: 'disIntegralValue', visible: true, align: 'center', valign: 'middle'},
        {title: '分润级别', field: 'disProLevel', visible: true, align: 'center', valign: 'middle'},
        {title: '用户类型', field: 'disUserType', visible: true, align: 'center', valign: 'middle'},
        {title: '用户段位', field: 'disUserRank', visible: true, align: 'center', valign: 'middle'},
        {title: '添加时间', field: 'addTime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
DisRankParam.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DisRankParam.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加段位积分
 */
DisRankParam.openAddDisRankParam = function () {
    var index = layer.open({
        type: 2,
        title: '添加段位积分',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/DisRankParam/DisRankParam_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看段位积分详情
 */
DisRankParam.openDisRankParamDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '段位积分详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/DisRankParam/DisRankParam_update/' + DisRankParam.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除段位积分
 */
DisRankParam.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/DisRankParam/delete", function (data) {
            Feng.success("删除成功!");
            DisRankParam.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询段位积分列表
 */
DisRankParam.search = function () {
    DisRankParam.table.refresh({query: DisRankParam.formParams()});
};
DisRankParam.formParams = function() {
    var queryData = {};
    queryData['calModel'] = $("#calModel").val();
    queryData['accountType'] = $("#accountType").val();
    queryData['disUserType'] = $("#disUserType").val();
    queryData['disUserRank'] = $("#disUserRank").val();
    return queryData;
}
$(function () {
    var defaultColunms = DisRankParam.initColumn();
    var table = new BSTable(DisRankParam.id, "/DisRankParam/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(DisRankParam.formParams());
    DisRankParam.table = table.init();
});
