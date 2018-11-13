/**
 * 初始化交易详情对话框
 */
var DisProfitRecordInfoDlg = {
    disProfitRecordInfoData : {}
};

/**
 * 清除数据
 */
DisProfitRecordInfoDlg.clearData = function() {
    this.disProfitRecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisProfitRecordInfoDlg.set = function(key, val) {
    this.disProfitRecordInfoData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DisProfitRecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DisProfitRecordInfoDlg.close = function() {
    parent.layer.close(window.parent.DisProfitRecord.layerIndex);
}

/**
 * 收集数据
 */
DisProfitRecordInfoDlg.collectData = function() {
    this.set('id');
}

/**
 * 提交添加
 */
DisProfitRecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/disProfitRecord/add", function(data){
        Feng.success("添加成功!");
        window.parent.DisProfitRecord.table.refresh();
        DisProfitRecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.disProfitRecordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DisProfitRecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/disProfitRecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.DisProfitRecord.table.refresh();
        DisProfitRecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.disProfitRecordInfoData);
    ajax.start();
}

$(function() {

});
