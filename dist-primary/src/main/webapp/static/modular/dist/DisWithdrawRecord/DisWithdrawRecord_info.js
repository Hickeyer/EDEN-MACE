/**
 * 初始化提现记录详情对话框
 */
var DisWithdrawRecordInfoDlg = {
    DisWithdrawRecordInfoData : {}
};

/**
 * 清除数据
 */
DisWithdrawRecordInfoDlg.clearData = function() {
    this.DisWithdrawRecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisWithdrawRecordInfoDlg.set = function(key, val) {
    this.DisWithdrawRecordInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisWithdrawRecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DisWithdrawRecordInfoDlg.close = function() {
    parent.layer.close(window.parent.DisWithdrawRecord.layerIndex);
}

/**
 * 收集数据
 */
DisWithdrawRecordInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
DisWithdrawRecordInfoDlg.addSubmit = function(type) {

    var id=$("#id").val();
    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DisWithdrawRecord/audit", function(data){
        Feng.success("添加成功!");
        window.parent.DisWithdrawRecord.table.refresh();
        DisWithdrawRecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set("id",id);
    ajax.set("type",type);
    ajax.start();
}

/**
 * 提交修改
 */
DisWithdrawRecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DisWithdrawRecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.DisWithdrawRecord.table.refresh();
        DisWithdrawRecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DisWithdrawRecordInfoData);
    ajax.start();
}

$(function() {

});
