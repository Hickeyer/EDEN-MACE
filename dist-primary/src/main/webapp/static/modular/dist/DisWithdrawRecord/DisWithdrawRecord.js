/**
 * 提现记录管理初始化
 */
var DisWithdrawRecord = {
    id: "DisWithdrawRecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DisWithdrawRecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '用户id', field: 'disUserId', visible: true, align: 'center', valign: 'middle'},
        {title: '订单号', field: 'withdrawNum', visible: true, align: 'center', valign: 'middle'},
        {title: '总金额', field: 'totalAmount', visible: true, align: 'center', valign: 'middle'},
        {title: '手续费', field: 'feeAmount', visible: true, align: 'center', valign: 'middle'},
        {title: '实际到账金额', field: 'realAmount', visible: true, align: 'center', valign: 'middle'},
        {title: '申请时间', field: 'withdrawTime', visible: true, align: 'center', valign: 'middle'},
        {title: '处理时间', field: 'handleTime', visible: true, align: 'center', valign: 'middle'},
        {title: '提现状态', field: 'withdrawDesc', visible: true, align: 'center', valign: 'middle'},
        {title: '提现账户', field: 'accountType', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
DisWithdrawRecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DisWithdrawRecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加提现记录
 */
DisWithdrawRecord.openAddDisWithdrawRecord = function () {
    if (this.check()) {
        var status = DisWithdrawRecord.seItem.withdrawStatus;
        console.log(status)
        if(status != 1){
            Feng.info("只能审核申请中的数据！");
            return ;
        }
        var index = layer.open({
            type: 2,
            title: '提现审核',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/DisWithdrawRecord/DisWithdrawRecord_audit/'+DisWithdrawRecord.seItem.id
        });
        this.layerIndex = index;
    }

};

/**
 * 打开查看提现记录详情
 */
DisWithdrawRecord.openDisWithdrawRecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '提现记录详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/DisWithdrawRecord/DisWithdrawRecord_update/' + DisWithdrawRecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除提现记录
 */
DisWithdrawRecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/DisWithdrawRecord/delete", function (data) {
            Feng.success("删除成功!");
            DisWithdrawRecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("DisWithdrawRecordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询提现记录列表
 */
DisWithdrawRecord.search = function () {
    DisWithdrawRecord.table.refresh({query: DisWithdrawRecord.formParams()});
};
DisWithdrawRecord.formParams = function() {
    var queryData = {};
    queryData['disUserId'] = $("#disUserId").val();
    queryData['withdrawNum'] = $("#withdrawNum").val();
    queryData['withdrawStatus'] = $("#withdrawStatus").val();
    queryData['accountType'] = $("#accountType").val();
    return queryData;
}
$(function () {
    var defaultColunms = DisWithdrawRecord.initColumn();
    var table = new BSTable(DisWithdrawRecord.id, "/DisWithdrawRecord/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(DisWithdrawRecord.formParams());
    DisWithdrawRecord.table = table.init();
});
