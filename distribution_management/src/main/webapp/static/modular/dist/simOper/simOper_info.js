/**
 * 初始化模拟菜单详情对话框
 */
var SimOperInfoDlg = {
    simOperInfoData : {}
};

/**
 * 清除数据
 */
SimOperInfoDlg.clearData = function() {
    this.simOperInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SimOperInfoDlg.set = function(key, val) {
    this.simOperInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
SimOperInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
SimOperInfoDlg.close = function() {
    parent.layer.close(window.parent.SimOper.layerIndex);
}

/**
 * 收集数据
 */
SimOperInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
SimOperInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/simOper/add", function(data){
        Feng.success("添加成功!");
        window.parent.SimOper.table.refresh();
        SimOperInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.simOperInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
SimOperInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/simOper/update", function(data){
        Feng.success("修改成功!");
        window.parent.SimOper.table.refresh();
        SimOperInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.simOperInfoData);
    ajax.start();
}

$(function() {

});
