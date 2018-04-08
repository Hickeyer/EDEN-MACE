/**
 * 初始化分销详情对话框
 */
var DisMemberInfoInfoDlg = {
    disMemberInfoInfoData : {}
};

/**
 * 清除数据
 */
DisMemberInfoInfoDlg.clearData = function() {
    this.disMemberInfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisMemberInfoInfoDlg.set = function(key, val) {
    this.disMemberInfoInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisMemberInfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DisMemberInfoInfoDlg.close = function() {
    parent.layer.close(window.parent.DisMemberInfo.layerIndex);
}

/**
 * 收集数据
 */
DisMemberInfoInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
DisMemberInfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/disMemberInfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.DisMemberInfo.table.refresh();
        DisMemberInfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.disMemberInfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DisMemberInfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/disMemberInfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.DisMemberInfo.table.refresh();
        DisMemberInfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.disMemberInfoInfoData);
    ajax.start();
}

$(function() {

});
