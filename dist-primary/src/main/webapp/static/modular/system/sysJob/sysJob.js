/**
 * 任务调度管理初始化
 */
var SysJob = {
    id: "SysJobTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SysJob.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
        {title: '任务名称', field: 'jobName', visible: true, align: 'center', valign: 'middle'},
        {title: '任务组', field: 'jobGroup', visible: true, align: 'center', valign: 'middle'},
        {title: '时间表达式', field: 'jobCron', visible: true, align: 'center', valign: 'middle'},
        {title: '类路径', field: 'jobClassPath', visible: true, align: 'center', valign: 'middle'},
        {title: '状态', field: 'statusInfo', visible: true, align: 'center', valign: 'middle'},
        {title: '描述', field: 'jobDescribe', visible: true, align: 'center', valign: 'middle'},
        {title:"操作",field:'Button',events:operateEvents,formatter:SysJob.AddFunction}
    ];
};

//状态:1启用 0停用
SysJob.AddFunction = function(value,row,index){

    if(row['jobStatus'] == 0){
        return [
            '<button id="confineMember" type="button" class="btn btn-primary ">启用</button>'
        ].join("");
    }else{
        return [
            '<button id="unConfineMember" type="button" class="btn btn-default">停用</button>'
        ].join("");
    }

}
window.operateEvents = {
    'click #confineMember':function (e,value,row,index) {

        SysJob.confineMembers(1,row['id']);

    },
    'click #unConfineMember':function (e,value,row,index) {

        SysJob.confineMembers(0,row['id']);

    },
}

SysJob.confineMembers = function (status,id) {
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sysJob/confine", function(data){
        Feng.success("处理成功!");
        SysJob.search();

    },function(data){
        Feng.error("处理失败!" + data.responseJSON.message + "!");
    });
    var confineData = {'status':status,'id':id};
    ajax.set(confineData);
    ajax.start();
}
/**
 * 检查是否选中
 */
SysJob.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        SysJob.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加任务调度
 */
SysJob.openAddSysJob = function () {
    var index = layer.open({
        type: 2,
        title: '添加任务调度',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/sysJob/sysJob_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看任务调度详情
 */
SysJob.openSysJobDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '任务调度详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/sysJob/sysJob_update/' + SysJob.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除任务调度
 */
SysJob.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/sysJob/delete", function (data) {
            Feng.success("删除成功!");
            SysJob.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("sysJobId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询任务调度列表
 */
SysJob.search = function () {
    var queryData = {};
    queryData['jobName'] = $("#jobName").val();
    SysJob.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = SysJob.initColumn();
    var table = new BSTable(SysJob.id, "/sysJob/list", defaultColunms);
    table.setPaginationType("server");
    SysJob.table = table.init();
});
