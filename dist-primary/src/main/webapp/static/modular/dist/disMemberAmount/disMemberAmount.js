/**
 * 会员账户管理管理初始化
 */
var DisMemberAmount = {
    id: "DisMemberAmountTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DisMemberAmount.initColumn = function () {
    var  col= [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '用户类型', field: 'typeDetail', visible: true, align: 'center', valign: 'middle'},
        {title: '平台id', field: 'disPlatformId', visible: true, align: 'center', valign: 'middle'},
        {title: '用户id', field: 'disUserId', visible: true, align: 'center', valign: 'middle'},
        {title: '用户名称', field: 'disUserName', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'amountStatus', visible: true, align: 'center', valign: 'middle'},
        {title: '总金额', field: 'totalAmount', visible: true, align: 'center', valign: 'middle'},
        {title: '可用金额', field: 'avaibleAmount', visible: true, align: 'center', valign: 'middle'},
        {title: '冻结金额', field: 'frozenAmount', visible: true, align: 'center', valign: 'middle'},]

    $.ajax({
        type: "post",
        url: Feng.ctxPath + "/disProfiParam/protype",
        async: false,
        success: function(data) {
            if(data.length>0){
                for (var i=0;i<data.length;i++){
                  var sub= {title: ''+data[i].dicValue+'(总)'+'', field: ''+data[i].dicNotes+"TotalAmount"+'', visible: true, align: 'center', valign: 'middle'}
                  var sub1= {title: ''+data[i].dicValue+'(冻结)'+'', field: ''+data[i].dicNotes+"FrozenAmount"+'', visible: true, align: 'center', valign: 'middle'}
                  var sub2= {title: ''+data[i].dicValue+'(可用)'+'', field: ''+data[i].dicNotes+"AvaibleAmount"+'', visible: true, align: 'center', valign: 'middle'}
                  col.push(sub);
                  col.push(sub1);
                  col.push(sub2);
                }
            }
        }
    });
    return  col ;
};

/**
 * 检查是否选中
 */
DisMemberAmount.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DisMemberAmount.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加会员账户管理
 */
DisMemberAmount.openAddDisMemberAmount = function () {
    var index = layer.open({
        type: 2,
        title: '添加会员账户管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/disMemberAmount/disMemberAmount_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看会员账户管理详情
 */
DisMemberAmount.openDisMemberAmountDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '会员账户管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/disMemberAmount/disMemberAmount_update/' + DisMemberAmount.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除会员账户管理
 */
DisMemberAmount.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/disMemberAmount/delete", function (data) {
            Feng.success("删除成功!");
            DisMemberAmount.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("disMemberAmountId",this.seItem.id);
        ajax.start();
    }
};
DisMemberAmount.setAmount = function () {
        var ajax = new $ax(Feng.ctxPath + "/disMemberAmount/synchInfo", function (data) {
            Feng.success("同步成功!");
            DisMemberAmount.table.refresh();
        }, function (data) {
            Feng.error("同步失败!" + data.responseJSON.message + "!");
        },true);
        ajax.start();
};

/**
 * 查询会员账户管理列表
 */
DisMemberAmount.search = function () {
    DisMemberAmount.table.refresh({query: DisMemberAmount.formParams()});
};


DisMemberAmount.formParams = function() {
    var queryData = {};

    queryData['disUserId'] = $("#disUserId").val();
    queryData['userType'] = $("#userType").val();

    return queryData;
}
$(function () {
    var defaultColunms = DisMemberAmount.initColumn();
    var table = new BSTable(DisMemberAmount.id, "/disMemberAmount/list", defaultColunms);
    table.setPaginationType("server");
    table.setQueryParams(DisMemberAmount.formParams());
    DisMemberAmount.table = table.init();
});
