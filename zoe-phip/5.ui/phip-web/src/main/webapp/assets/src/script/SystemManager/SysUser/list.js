﻿define(function (require, exports, module) {
    var request = require("./req.js").req;
    var BaseGrid = require("../../baseGrid/baseGrid.js");

    var internal = {
        init: function () {
            internal.__grid = new BaseGrid({
                deleteUrl: {
                    deleteInfo: "/user/delete",
                    deleteList: "/user/delete/all"
                },
                //工具条
                tools: {
                    searchbox: [
                        //{ descr: '开始时间', name: 'beginDate', type: 'date' },
                        { descr: '关键字', name: 'keyWord', type: 'text' }
                    ]
                },
                //表格参数
                gridParam: {
                    url: webRoot + '/user/list',
                    columns: [
                    { display: '名称', name: 'name', width: 120, align: 'left' },
                    { display: '登录名', name: 'loginName', width: 120, align: 'left' },
                    { display: '注册时间', name: 'createAt', width: 120, align: 'left', type: 'date' },
                        {
                            display: '状态',
                            name: 'state',
                            width: 80,
                            align: "center",
                            render: function (rowdata, index, value) {
                                if (value == 1) {
                                    return '<a href="javascript:changeState(\'' + rowdata.Id + '\', 0);" class="btn-switch-outer"><span class="btn-switch btn-switch-on"><b class="btn-switch-inner"></b></span></a>';
                                } else {
                                    return '<a href="javascript:changeState(\'' + rowdata.Id + '\', 1);" class="btn-switch-outer"><span class="btn-switch btn-switch-off"><b class="btn-switch-inner"></b></span></a>';
                                }
                            }
                        }
                    ]
                },
                //弹出参数配置
                dialogParam: {
                    common: {
                        width: 390,
                        height: 250,
                        url: webRoot + 'detail'
                    },
                    add: {
                        title: '新增用户信息'
                    },
                    edit: {
                        title: '编辑用户信息'
                    }
                }
            });
        },
        changeState: function (id, state) {
            common.confirm('您确定切换状态吗?', function () {

                request.updateState(id, state, function () {
                    common.jsmsgSuccess('状态切换成功!');
                    internal.__grid.reload();
                });

            });
        }
    };
    window.changeState = internal.changeState;
    exports.init = function () {
        internal.init();
    }
});