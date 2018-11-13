/**
 * 初始化垂直升级配置详情对话框
 */
var DisUpgradeParamInfoDlg = {
    DisUpgradeParamInfoData : {}
};

/**
 * 清除数据
 */
DisUpgradeParamInfoDlg.clearData = function() {
    this.DisUpgradeParamInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisUpgradeParamInfoDlg.set = function(key, val) {
    this.DisUpgradeParamInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisUpgradeParamInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DisUpgradeParamInfoDlg.close = function() {
    parent.layer.close(window.parent.DisUpgradeParam.layerIndex);
}

/**
 * 收集数据
 */
DisUpgradeParamInfoDlg.collectData = function() {
    this.set('id').set("disUserRank")
        .set("beginIntegral")
        .set("endIntegral")
        .set("upgradeName");
}

/**
 * 提交添加
 */
DisUpgradeParamInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DisUpgradeParam/agent/add", function(data){
        Feng.success("添加成功!");
        window.parent.DisUpgradeParam.table.refresh();
        DisUpgradeParamInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DisUpgradeParamInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DisUpgradeParamInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DisUpgradeParam/update", function(data){
        Feng.success("修改成功!");
        window.parent.DisUpgradeParam.table.refresh();
        DisUpgradeParamInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DisUpgradeParamInfoData);
    ajax.start();
}

$(function() {

});
