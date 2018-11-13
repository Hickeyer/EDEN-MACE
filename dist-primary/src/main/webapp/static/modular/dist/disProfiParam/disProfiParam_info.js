/**
 * 初始化参数设置详情对话框
 */
var DisProfiParamInfoDlg = {
    disProfiParamInfoData : {}
};

/**
 * 清除数据
 */
DisProfiParamInfoDlg.clearData = function() {
    this.disProfiParamInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisProfiParamInfoDlg.set = function(key, val) {
    this.disProfiParamInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisProfiParamInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DisProfiParamInfoDlg.close = function() {
    parent.layer.close(window.parent.DisProfiParam.layerIndex);
}

/**
 * 收集数据
 */
DisProfiParamInfoDlg.collectData = function() {
    this.set('disProValue').set('calModel').set('accountType').set('disProLevel').set('disUserType')
        .set('disPlatformId').set("disUserRank");
}

/**
 * 提交添加
 */
DisProfiParamInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/disProfiParam/add", function(data){
        Feng.success("添加成功!");
        window.parent.DisProfiParam.table.refresh();
        DisProfiParamInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.disProfiParamInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DisProfiParamInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/disProfiParam/update", function(data){
        Feng.success("修改成功!");
        window.parent.DisProfiParam.table.refresh();
        DisProfiParamInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.disProfiParamInfoData);
    ajax.start();
}

$(function() {

});
