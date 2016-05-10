package com.zoe.phip.web.controller.StandardManage;

import com.zoe.phip.infrastructure.annotation.AuthAction;
import com.zoe.phip.infrastructure.entity.PageList;
import com.zoe.phip.infrastructure.entity.ServiceResult;
import com.zoe.phip.infrastructure.entity.ServiceResultT;
import com.zoe.phip.infrastructure.security.Permission;
import com.zoe.phip.web.context.ComSession;
import com.zoe.phip.web.context.ServiceFactory;
import com.zoe.phip.web.controller.BaseController;
import com.zoe.phip.web.model.sdm.StElementInfo;
import com.zoe.phip.web.model.sdm.StSetInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenzhisen on 2016/5/6.
 */
@Controller
@RequestMapping("/dataSet")
public class DataSetController extends BaseController {
    //region 数据集 View

    @RequestMapping("/view/dataSetList")
    @AuthAction(permission = {Permission.View}, name = "查看")
    public String ToDataSetList(HttpServletRequest request, Model model) {
        return "/StandardManage/DataSet/dataSetList";
    }

    @RequestMapping("/view/dataSetDetail")
    public String ToDataSetDetail(HttpServletRequest request, Model model) {
        return "/StandardManage/DataSet/dataSetDetail";
    }

    @RequestMapping("/view/columnList")
    @AuthAction(permission = {Permission.View}, name = "查看")
    public String ToColumnList(HttpServletRequest request, Model model) {
        return "/StandardManage/DataSet/columnList";
    }

    @RequestMapping("/view/columnDetail")
    public String ToColumnDetail(HttpServletRequest request, Model model) {
        return "/StandardManage/DataSet/columnDetail";
    }
    //endregion

    //region 数据集 Json
    @RequestMapping(value = "/getSetList")
    @ResponseBody
    @AuthAction(permission = {Permission.Query}, name = "查询")
    public ServiceResultT<PageList<StSetInfo>> getSetList(String keyWord) {
        return ServiceFactory.getStSetInfoService().getDataPageList(ComSession.getUserInfo(), keyWord, getQueryPage());
    }

    @RequestMapping(value = "/getSetInfo")
    @ResponseBody
    @AuthAction(permission = {Permission.Query}, name = "查询")
    public ServiceResult getSetInfo(String id, HttpServletRequest request) {
        return ServiceFactory.getStSetInfoService().getById(ComSession.getUserInfo(), id);
    }
    /**
     *
     * @param StSetInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/addSetInfo")
    @ResponseBody
    @AuthAction(permission = {Permission.Add}, name = "新增")
    public ServiceResult addSetInfo(StSetInfo StSetInfo, HttpServletRequest request) {
        return ServiceFactory.getStSetInfoService().add(ComSession.getUserInfo(), StSetInfo);
    }

    /**
     *
     * @param StSetInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateSetInfo")
    @ResponseBody
    @AuthAction(permission = {Permission.Update}, name = "更新")
    public ServiceResult updateSetInfo(StSetInfo StSetInfo, HttpServletRequest request) {
        return ServiceFactory.getStSetInfoService().update(ComSession.getUserInfo(), StSetInfo);
    }

    /**
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/deleteSetInfo")
    @ResponseBody
    @AuthAction(permission = {Permission.Delete}, name = "删除")
    public ServiceResult deleteSetInfo(String ids) {
        return ServiceFactory.getStSetInfoService().deleteByIds(ComSession.getUserInfo(), ids);
    }

    //endregion
}
