/**
 * Created by linqinghuang on 2016/5/4.
 */

define(function (require, exports, module) {
    var internal = {
        sex: '2.16.156.10011.2.3.3.4',//生理性别代码
        maritalStatus: '2.16.156.10011.2.3.3.5',//婚姻状况
        national: '2.16.156.10011.2.3.3.3',//民族类别
        orgClassification: '2.16.156.10011.2.3.4.1',//卫生机构分类代码表，
        department: '2.16.156.10011.2.3.2.62',//医疗卫生机构业务科室分类与代码表
        occupation: '2.16.156.10011.2.3.3.7',//职业分类与代码
        healthCareType: '2.16.156.10011.2.3.1.248',// 医保类型
        departType: '2.16.156.10011.1.26',//科室机构标识：科室
        orgType: '2.16.156.10011.1.5',//科室机构标识：机构
        duty: '2.16.156.10011.2.3.3.10'//专业技术职务代码：职务


    }
    exports.oidCodeConfig = internal;
});
