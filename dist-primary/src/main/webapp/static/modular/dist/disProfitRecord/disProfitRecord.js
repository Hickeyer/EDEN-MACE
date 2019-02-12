/**
 * 交易管理初始化
 */
var DisProfitRecord = {
    id: "DisProfitRecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DisProfitRecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '分润类型', field: 'typeDetail', visible: true, align: 'center', valign: 'middle'},
        {title: '收益账户', field: 'disGetUserId', visible: true, align: 'center', valign: 'middle'},
        {title: '交易账户', field: 'disSetUserId', visible: true, align: 'center', valign: 'middle'},
        {title: '收益', field: 'disAmount', visible: true, align: 'center', valign: 'middle'},
        {title: '账户类型', field: 'accountType', visible: true, align: 'center', valign: 'middle'},
        {title: '订单号', field: 'disOrderId', visible: true, align: 'center', valign: 'middle'},
        {title: '备注', field: 'disNote', visible: true, align: 'center', valign: 'middle'},
        {title: '交易时间', field: 'addTime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
DisProfitRecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DisProfitRecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加交易
 */
DisProfitRecord.openAddDisProfitRecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加交易',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/disProfitRecord/disProfitRecord_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看交易详情
 */
DisProfitRecord.openDisProfitRecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '交易详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/disProfitRecord/disProfitRecord_update/' + DisProfitRecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除交易
 */
DisProfitRecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/disProfitRecord/delete", function (data) {
            Feng.success("删除成功!");
            DisProfitRecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("disProfitRecordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询交易列表
 */
DisProfitRecord.search = function () {
    DisProfitRecord.table.refresh({query: DisProfitRecord.formParams()});
};
DisProfitRecord.formParams = function() {
    var queryData = {};
    queryData['disGetUserId'] = $("#disGetUserId").val();
    queryData['disSetUserId'] = $("#disSetUserId").val();
    queryData['disOrderId'] = $("#disOrderId").val();
    queryData['accountType'] = $("#accountType").val();
    queryData['userType'] = $("#userType").val();
    return queryData;
}
$(function () {
    var defaultColunms = DisProfitRecord.initColumn();
    var table = new BSTable(DisProfitRecord.id, "/disProfitRecord/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(DisProfitRecord.formParams());
    DisProfitRecord.table = table.init();
});
