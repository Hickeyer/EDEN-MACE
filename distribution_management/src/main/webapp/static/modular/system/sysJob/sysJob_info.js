/**
 * 初始化任务调度详情对话框
 */
var SysJobInfoDlg = {
    sysJobInfoData : {}
};

/**
 * 清除数据
 */
SysJobInfoDlg.clearData = function() {
    this.sysJobInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SysJobInfoDlg.set = function(key, val) {
    this.sysJobInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SysJobInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SysJobInfoDlg.close = function() {
    parent.layer.close(window.parent.SysJob.layerIndex);
}

/**
 * 收集数据
 */
SysJobInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
SysJobInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sysJob/add", function(data){
        Feng.success("添加成功!");
        window.parent.SysJob.table.refresh();
        SysJobInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sysJobInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SysJobInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/sysJob/update", function(data){
        Feng.success("修改成功!");
        window.parent.SysJob.table.refresh();
        SysJobInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.sysJobInfoData);
    ajax.start();
}

$(function() {

});
