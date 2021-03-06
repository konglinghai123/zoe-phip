/**
 * Created by linqinghuang on 2016/3/15.
 */
define(function (require, exports, module) {
    var options = {
        treeId: 'tree',
        btnBox: 'treeBtns',
        tools: {
            /*'add':true,'edit':true,'del':true,'refresh':true*/
            btns: {'add': false, 'edit': false, 'del': false},
            search: []
        },
        url: {
            getTreeList: ""
        },
        renderData: function (data) {
            return data.result.rows;
        },
        validate: {
            //点击新增按钮验证
            add: {
                isValidate: false,
                fn: function (data) {
                    return false;//验证是否通过
                }
            },
            //点击编辑按钮验证
            edit: {
                isValidate: false,
                fn: function (data) {
                    return false;//验证是否通过
                }
            },
            //点击删除按钮验证
            del: {
                isValidate: false,
                fn: function (data) {
                    return false;//验证是否通过
                }
            }
        },
        treeParam: {},
        dialogParam: {
            winName: "",
            winCallback: "",
            titleKey: null,//弹窗标题索引 如"编辑用户--张三"其中张三是通过索'userName'获取
            common: {
                otherUrlParam: {},//用来存除id外的其他url参数
                width: 800,
                height: 600,
                buttons: [
                    {
                        //verifySubmit自己的验证提交状态
                        text: "确定",
                        verifySubmit: true,
                        submitText: '提交中...',
                        onclick: function (item, dialog, submited) {
                        }
                    },
                    {
                        text: "取消",
                        onclick: function (item, dialog) {
                            dialog.close();
                        }
                    }
                ]
            },
            //新增参数
            add: {
                title: "新增信息"
            },
            //编辑参数
            edit: {
                title: "编辑信息"
            }
        }
    }
    exports.defaultOptions = options;
})