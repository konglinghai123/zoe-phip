/**
 * Created by zhangxingcai on 2016/4/29 0029.
 */
define(function (require, exports, module) {
    var internal = {
        area: {
            winName: 'win_area_select_list',
            title: '行政区划选择列表',
            selectParam: {
                stroage: [],
                displayField: 'name',
                valueField: 'id',
                gridParam: {
                    url: webRoot + 'area/getAreaList',
                    columns: [
                        {display: '代码', name: 'code', width: 160, align: 'left'},
                        {display: '名称', name: 'name', width: 180, align: 'left'}
                    ],
                    usePager: false,
                    tree: {
                        columnId: 'id',
                        columnName: 'name',
                        idField: 'id',
                        parentIDField: 'pid'
                    },
                    height: 250
                },
                multiselect: false,//是否多选:true为多选，false为单选
                winCallback: 'win_area_select_list_callback'
            }
        }
    }
    exports.area = internal.area;
});