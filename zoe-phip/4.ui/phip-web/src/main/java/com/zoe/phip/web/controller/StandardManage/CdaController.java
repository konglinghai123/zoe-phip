package com.zoe.phip.web.controller.StandardManage;

import com.zoe.phip.infrastructure.annotation.AuthAction;
import com.zoe.phip.infrastructure.entity.PageList;
import com.zoe.phip.infrastructure.entity.ServiceResult;
import com.zoe.phip.infrastructure.entity.ServiceResultT;
import com.zoe.phip.infrastructure.security.Permission;
import com.zoe.phip.web.context.ComSession;
import com.zoe.phip.web.context.ServiceFactory;
import com.zoe.phip.web.controller.BaseController;
import com.zoe.phip.web.model.sdm.StCdaInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by chenzhisen on 2016/5/6.
 */
@Controller
@RequestMapping("cda")
public class CdaController extends BaseController {

    @RequestMapping("/view/cdaList")
    @AuthAction(permission = {Permission.View}, name = "查看")
    public String ToCdaList(HttpServletRequest request, Model model) {
        return "/StandardManage/cda/cdaList";
    }

    @RequestMapping("/view/dataSetList")
    @AuthAction(permission = {Permission.View}, name = "查看")
    public String ToDataSetList(HttpServletRequest request, Model model) {
        return "/StandardManage/cda/dataSetList";
    }

    @RequestMapping("/view/cdaDetail")
    public String ToDataSetDetail(HttpServletRequest request, Model model) {

        return "/StandardManage/cda/cdaDetail";
    }

    @RequestMapping("/view/showXSLToStruct")
    public String ToShowXSLToStruct(HttpServletRequest request, Model model) {

        return "/StandardManage/cda/ShowXSLToStruct";
    }

    @RequestMapping("/view/editXsl")
    public String ToEditXsl(HttpServletRequest request, Model model) {

        return "/StandardManage/cda/editXsl";
    }

    @RequestMapping("/view/previewXsl")
    public String ToPreviewXsl(HttpServletRequest request, Model model) {

        return "/StandardManage/cda/previewXsl";
    }

    /**
     * 根据关键字查询CDA列表信息
     *
     * @param keyWord
     * @return
     */
    @RequestMapping(value = "/getCdaList")
    @ResponseBody
    @AuthAction(permission = {Permission.Query}, name = "查询")
    public ServiceResultT<PageList<StCdaInfo>> getCdaList(String keyWord) {
        return ServiceFactory.getStCdaInfoService().getDataPageList(ComSession.getUserInfo(), keyWord, getQueryPage());
    }

    /**
     * 根据id查询Cda信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getCdaInfo")
    @ResponseBody
    @AuthAction(permission = {Permission.Query}, name = "查询")
    public ServiceResult getCdaInfo(String id) {
        return ServiceFactory.getStCdaInfoService().getById(ComSession.getUserInfo(), id);
    }

    /**
     * 新增Cda信息
     *
     * @param stCdaInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/addCdaInfo")
    @ResponseBody
    @AuthAction(permission = {Permission.Add}, name = "新增")
    public ServiceResult addCdaInfo(StCdaInfo stCdaInfo, HttpServletRequest request) {
        return ServiceFactory.getStCdaInfoService().add(ComSession.getUserInfo(), stCdaInfo);
    }

    /**
     * 更新Cda信息
     *
     * @param stCdaInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateCdaInfo")
    @ResponseBody
    @AuthAction(permission = {Permission.Update}, name = "更新")
    public ServiceResult updateCdaInfo(StCdaInfo stCdaInfo, HttpServletRequest request) {
        return ServiceFactory.getStCdaInfoService().update(ComSession.getUserInfo(), stCdaInfo);
    }

    /**
     * 删除Cda信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delCdaInfo")
    @ResponseBody
    @AuthAction(permission = {Permission.Update}, name = "更新")
    public ServiceResult delCdaInfo(String id) {
        return ServiceFactory.getStCdaInfoService().deleteById(ComSession.getUserInfo(), id);
    }

    /**
     * 批量删除Cda信息
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/delCdaList")
    @ResponseBody
    @AuthAction(permission = {Permission.Update}, name = "更新")
    public ServiceResult delCdaList(String ids) {
        return ServiceFactory.getStCdaInfoService().deleteByIds(ComSession.getUserInfo(), ids);
    }

    /**
     * 根据标准来源和关键字查询CDA信息
     *
     * @param fkSourceId
     * @param keyWord
     * @return
     */
    @RequestMapping(value = "/getBySourceId")
    @ResponseBody
    public ServiceResultT<PageList<StCdaInfo>> getBySourceId(String fkSourceId, String keyWord) {
        return ServiceFactory.getStCdaInfoService().getBySourceId(ComSession.getUserInfo(), fkSourceId, keyWord, getQueryPage());
    }

}
