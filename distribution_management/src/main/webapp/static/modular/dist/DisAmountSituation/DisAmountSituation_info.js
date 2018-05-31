/**
 * 初始化记账表详情对话框
 */
var DisAmountSituationInfoDlg = {
    DisAmountSituationInfoData : {}
};

/**
 * 清除数据
 */
DisAmountSituationInfoDlg.clearData = function() {
    this.DisAmountSituationInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisAmountSituationInfoDlg.set = function(key, val) {
    this.DisAmountSituationInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisAmountSituationInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DisAmountSituationInfoDlg.close = function() {
    parent.layer.close(window.parent.DisAmountSituation.layerIndex);
}

/**
 * 收集数据
 */
DisAmountSituationInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
DisAmountSituationInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DisAmountSituation/add", function(data){
        Feng.success("添加成功!");
        window.parent.DisAmountSituation.table.refresh();
        DisAmountSituationInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DisAmountSituationInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DisAmountSituationInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DisAmountSituation/update", function(data){
        Feng.success("修改成功!");
        window.parent.DisAmountSituation.table.refresh();
        DisAmountSituationInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DisAmountSituationInfoData);
    ajax.start();
}

$(function() {

});
