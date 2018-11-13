/**
 * 初始化段位积分详情对话框
 */
var DisRankParamInfoDlg = {
    DisRankParamInfoData : {}
};

/**
 * 清除数据
 */
DisRankParamInfoDlg.clearData = function() {
    this.DisRankParamInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisRankParamInfoDlg.set = function(key, val) {
    this.DisRankParamInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisRankParamInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DisRankParamInfoDlg.close = function() {
    parent.layer.close(window.parent.DisRankParam.layerIndex);
}

/**
 * 收集数据
 */
DisRankParamInfoDlg.collectData = function() {
    this.set('disIntegralValue').set('calModel').set('accountType').set('disProLevel').set('disUserType')
        .set('disPlatformId').set("disUserRank").set("disRankName").set("id");
}

/**
 * 提交添加
 */
DisRankParamInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DisRankParam/add", function(data){
        Feng.success("添加成功!");
        window.parent.DisRankParam.table.refresh();
        DisRankParamInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DisRankParamInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DisRankParamInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DisRankParam/update", function(data){
        Feng.success("修改成功!");
        window.parent.DisRankParam.table.refresh();
        DisRankParamInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DisRankParamInfoData);
    ajax.start();
}

$(function() {

});
