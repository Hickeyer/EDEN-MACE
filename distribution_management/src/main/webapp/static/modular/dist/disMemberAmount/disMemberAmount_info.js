/**
 * 初始化会员账户管理详情对话框
 */
var DisMemberAmountInfoDlg = {
    disMemberAmountInfoData : {}
};

/**
 * 清除数据
 */
DisMemberAmountInfoDlg.clearData = function() {
    this.disMemberAmountInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisMemberAmountInfoDlg.set = function(key, val) {
    this.disMemberAmountInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisMemberAmountInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DisMemberAmountInfoDlg.close = function() {
    parent.layer.close(window.parent.DisMemberAmount.layerIndex);
}

/**
 * 收集数据
 */
DisMemberAmountInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
DisMemberAmountInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/disMemberAmount/add", function(data){
        Feng.success("添加成功!");
        window.parent.DisMemberAmount.table.refresh();
        DisMemberAmountInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.disMemberAmountInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DisMemberAmountInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/disMemberAmount/update", function(data){
        Feng.success("修改成功!");
        window.parent.DisMemberAmount.table.refresh();
        DisMemberAmountInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.disMemberAmountInfoData);
    ajax.start();
}

$(function() {

});
