/**
 * 初始化秘钥生成详情对话框
 */
var KeyInfoDlg = {
    keyInfoData : {}
};

/**
 * 清除数据
 */
KeyInfoDlg.clearData = function() {
    this.keyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KeyInfoDlg.set = function(key, val) {
    this.keyInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
KeyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
KeyInfoDlg.close = function() {
    parent.layer.close(window.parent.Key.layerIndex);
}

/**
 * 收集数据
 */
KeyInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
KeyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/key/add", function(data){
        Feng.success("添加成功!");
        window.parent.Key.table.refresh();
        KeyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.keyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
KeyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/key/update", function(data){
        Feng.success("修改成功!");
        window.parent.Key.table.refresh();
        KeyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.keyInfoData);
    ajax.start();
}

$(function() {

});
