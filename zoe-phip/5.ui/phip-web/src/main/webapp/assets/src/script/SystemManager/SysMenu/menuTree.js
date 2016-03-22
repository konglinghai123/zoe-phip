﻿define(function (require, exports, module) {
    var internal = {
        req: require("./req.js").req,
        treeObj: null,
        init: function () {

            internal.buildTree();
            internal.onSave();
        },
        setting: {
            data: {
                keep: {
                    parent: true
                },
                key: {
                    name: 'Name'
                },
                simpleData: {
                    enable: true,
                    idKey: 'Id',
                    name: "Name",
                    pIdKey: 'FkParentMenuId',
                    rootPId: "root"
                }
            },
            edit: {
                drag: {
                    autoExpandTrigger: true
                },
                enable: true,
                showRemoveBtn: false,
                showRenameBtn: false
            },
            callback: {
                beforeDrag: function () {
                    var isDrag = common.getParamFormUrl("noDrag") == 1 ? false : true
                    return isDrag;
                },
                onClick: function (event, treeId, treeNode) {
                    var isDrag = common.getParamFormUrl("noDrag") == 1 ? false : true;
                    if (!isDrag) {
                        var top = common.getTopWindowDom();
                        if ($.isFunction(top.win_menu_tree_select_callback)) {
                            if (top.win_menu_tree_select_callback(treeNode) === true)
                                setTimeout(function() {
                                    top.win_menu_tree_dialog.close();
                                }, 1);
                        }
                    }
                }
            }
        },
        buildTree: function () {
            internal.req.getList(null, function (data) {
                var treeData = $.merge([{ Id: 0, Name: '菜单根节点', FkParentMenuId: "root" }], data.Result.Rows);
                var treeObj = $.fn.zTree.init($("#tree"), internal.setting, treeData);
                treeObj.expandAll(true);
            })
        },
        onSave: function () {
            var top = common.getTopWindowDom();
            top.win_menu_tree_callback = function (reloadGrid) {
                var treeObj = $.fn.zTree.getZTreeObj("tree");
                var ztreeNodes = treeObj.getNodes();
                var nodes = treeObj.transformToArray(ztreeNodes);
                nodes.splice(0, 1);
                internal.req.updateList({ list: JSON.stringify(nodes) }, function (result) {
                    if (result.IsSuccess) {
                        var top = common.getTopWindowDom();
                        reloadGrid();
                        top.win_menu_tree_dialog.close();
                    }

                });
            }
        }

    };
    exports.init = function () {
        internal.init();
    }
})