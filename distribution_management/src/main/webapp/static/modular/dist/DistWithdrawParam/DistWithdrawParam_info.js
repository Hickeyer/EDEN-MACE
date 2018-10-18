/**
 * 初始化提现参数设置详情对话框
 */
var DistWithdrawParamInfoDlg = {
    DistWithdrawParamInfoData : {}
};

/**
 * 清除数据
 */
DistWithdrawParamInfoDlg.clearData = function() {
    this.DistWithdrawParamInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DistWithdrawParamInfoDlg.set = function(key, val) {
    this.DistWithdrawParamInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DistWithdrawParamInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DistWithdrawParamInfoDlg.close = function() {
    parent.layer.close(window.parent.DistWithdrawParam.layerIndex);
}

/**
 * 收集数据
 */
DistWithdrawParamInfoDlg.collectData = function() {
    this.set('id').set("beginAmount").set("endAmount")
        .set("disWithdrawValue").set("calModel");
}

/**
 * 提交添加
 */
DistWithdrawParamInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DistWithdrawParam/add", function(data){
        Feng.success("添加成功!");
        window.parent.DistWithdrawParam.table.refresh();
        DistWithdrawParamInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DistWithdrawParamInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DistWithdrawParamInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/DistWithdrawParam/update", function(data){
        Feng.success("修改成功!");
        window.parent.DistWithdrawParam.table.refresh();
        DistWithdrawParamInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.DistWithdrawParamInfoData);
    ajax.start();
}

$(function() {

});
