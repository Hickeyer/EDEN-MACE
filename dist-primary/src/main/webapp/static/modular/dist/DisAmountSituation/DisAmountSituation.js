/**
 * 记账表管理初始化
 */
var DisAmountSituation = {
    id: "DisAmountSituationTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DisAmountSituation.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
DisAmountSituation.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DisAmountSituation.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加记账表
 */
DisAmountSituation.openAddDisAmountSituation = function () {
    var index = layer.open({
        type: 2,
        title: '添加记账表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/DisAmountSituation/DisAmountSituation_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看记账表详情
 */
DisAmountSituation.openDisAmountSituationDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '记账表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/DisAmountSituation/DisAmountSituation_update/' + DisAmountSituation.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除记账表
 */
DisAmountSituation.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/DisAmountSituation/delete", function (data) {
            Feng.success("删除成功!");
            DisAmountSituation.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("DisAmountSituationId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询记账表列表
 */
DisAmountSituation.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DisAmountSituation.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DisAmountSituation.initColumn();
    var table = new BSTable(DisAmountSituation.id, "/DisAmountSituation/list", defaultColunms);
    table.setPaginationType("client");
    DisAmountSituation.table = table.init();
});
