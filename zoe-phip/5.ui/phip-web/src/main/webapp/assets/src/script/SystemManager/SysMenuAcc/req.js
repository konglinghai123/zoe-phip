﻿define(function (require, exports, module) {
    var internal = {
        getCurrentUserList: function (catalogId, keyWord) {
            var list = [];
            var req = new Request("/menu/getUserCfg");
            req.post({
                isTip: false,
                async: false,
                data: { catalogId: catalogId, keyWord: keyWord, page: 1, pagesize: 999999999 },
                success: function (data) {
                    if (data && data.result && data.result.total > 0) {
                        for (var item in data.result.rows) {
                            var menuItem = {
                                Id: data.result.rows[item].id,
                                Name: data.result.rows[item].name
                            }
                            list.push(menuItem);
                        }
                    }
                }
            });
            return list;
        }
    };
    exports.req = internal;
});