/**
 * 秘钥生成管理初始化
 */
var Key = {
    id: "KeyTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Key.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
        {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Key.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Key.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加秘钥生成
 */
Key.openAddKey = function () {
    var index = layer.open({
        type: 2,
        title: '添加秘钥生成',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/key/key_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看秘钥生成详情
 */
Key.openKeyDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '秘钥生成详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/key/key_update/' + Key.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除秘钥生成
 */
Key.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/key/delete", function (data) {
            Feng.success("删除成功!");
            Key.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("keyId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询秘钥生成列表
 */
Key.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Key.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Key.initColumn();
    var table = new BSTable(Key.id, "/key/list", defaultColunms);
    table.setPaginationType("client");
    Key.table = table.init();
});
