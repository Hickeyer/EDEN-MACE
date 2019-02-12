/**
 * 提现参数设置管理初始化
 */
var DistWithdrawParam = {
    id: "DistWithdrawParamTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DistWithdrawParam.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: '开始金额', field: 'beginAmount', visible: true, align: 'center', valign: 'middle'},
        {title: '结束金额', field: 'endAmount', visible: true, align: 'center', valign: 'middle'},
        {title: '计算模型', field: 'calModel', visible: true, align: 'center', valign: 'middle'},
        {title: '计算基础', field: 'disWithdrawValue', visible: true, align: 'center', valign: 'middle'},
        {title: '添加时间', field: 'addTime', visible: true, align: 'center', valign: 'middle'},
    ];
};

/**
 * 检查是否选中
 */
DistWithdrawParam.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DistWithdrawParam.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加提现参数设置
 */
DistWithdrawParam.openAddDistWithdrawParam = function () {
    var index = layer.open({
        type: 2,
        title: '添加提现参数设置',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/DistWithdrawParam/DistWithdrawParam_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看提现参数设置详情
 */
DistWithdrawParam.openDistWithdrawParamDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '提现参数设置详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/DistWithdrawParam/DistWithdrawParam_update/' + DistWithdrawParam.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除提现参数设置
 */
DistWithdrawParam.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/DistWithdrawParam/delete", function (data) {
            Feng.success("删除成功!");
            DistWithdrawParam.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("id",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询提现参数设置列表
 */
DistWithdrawParam.search = function () {
    var queryData = {};

    DistWithdrawParam.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DistWithdrawParam.initColumn();
    var table = new BSTable(DistWithdrawParam.id, "/DistWithdrawParam/list", defaultColunms);
    table.setPaginationType("client");
    DistWithdrawParam.table = table.init();
});
