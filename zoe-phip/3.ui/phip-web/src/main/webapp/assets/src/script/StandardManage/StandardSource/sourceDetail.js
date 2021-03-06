/**
 * Created by zhangxingcai on 2016/5/6 0006.
 */
define(function (require, exports, module) {
    var internal = {
            init: function () {
                var BaseAttr = require("{staticDir}/BaseAttr/baseAttr");
                var sysDictConfig = require("{dir}/JsConfig/sysDictConfig").sysDictConfig;
                var baseAttr = new BaseAttr({
                        winName: "win_source_detail_dialog",//弹窗对象变量名称
                        winCallback: "win_source_detail_callback",//弹窗回调函数
                        getUrl: 'source/getSourceInfo',//
                        addUrl: 'source/addSourceInfo',//新增接口Url
                        updateUrl: 'source/updateSourceInfo',//修改接口Url/修改的接口Url
                        loadPageEvent: function () {
                            $("#selstandardType").select({
                                localData: true,
                                name: 'standardType'
                            }),
                                //数据资源库类别
                                $("#fkSourceType").select({
                                    name: 'fkDictId',
                                    display: 'dictName',
                                    ajaxParam: {
                                        url: 'dict/getDictItemsByCategoryCode ',//url 请求的地址
                                        data: {catalogCode: sysDictConfig.sourceType}
                                    },
                                    value: 'id',//值
                                    text: 'name'//展示的内容
                                });
                        }

                    }
                );
            },
        }
        ;
    exports.init = function () {
        internal.init();
    }
})
;