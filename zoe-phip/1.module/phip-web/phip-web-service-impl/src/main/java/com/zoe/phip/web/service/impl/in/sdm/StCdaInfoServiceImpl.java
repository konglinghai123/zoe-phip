/*
 * Powered By zoe
 * Since 2008 - 2016
 */

package com.zoe.phip.web.service.impl.in.sdm;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageInfo;
import com.zoe.phip.infrastructure.annotation.ErrorMessage;
import com.zoe.phip.infrastructure.entity.PageList;
import com.zoe.phip.infrastructure.entity.QueryPage;
import com.zoe.phip.infrastructure.entity.SortOrder;
import com.zoe.phip.infrastructure.entity.SystemData;
import com.zoe.phip.infrastructure.exception.BusinessException;
import com.zoe.phip.infrastructure.util.MapUtil;
import com.zoe.phip.infrastructure.util.StringUtil;
import com.zoe.phip.infrastructure.util.XmlUtil;
import com.zoe.phip.module.service.impl.in.BaseInServiceImpl;
import com.zoe.phip.module.service.util.SqlHelper;
import com.zoe.phip.web.dao.sdm.IStCdaInfoMapper;
import com.zoe.phip.web.model.sdm.StCdaInfo;
import com.zoe.phip.web.model.sdm.StRsCdaSetInfo;
import com.zoe.phip.web.service.sdm.IStCdaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author
 * @version 1.0
 * @date 2016-05-03
 */
@Repository("stCdaInfoService")
@Service(interfaceClass = IStCdaInfoService.class, protocol = {"dubbo"}, proxy = "sdpf", dynamic = true)
@ErrorMessage(code = "001", message = "CDA标识({0})已经存在!")
@ErrorMessage(code = "002",message = "样例文件内容不能为空!")
@ErrorMessage(code = "003",message = "解析HTML文件内容不能为空!")
@ErrorMessage(code = "004",message = "记录已经被删除!")
public class StCdaInfoServiceImpl extends BaseInServiceImpl<StCdaInfo, IStCdaInfoMapper> implements IStCdaInfoMapper {

    @Autowired
    private StRsCdaSetInfoServiceImpl infoServiceImpl;

    public PageList<StCdaInfo> getDataPageList(String key, QueryPage queryPage) {
        queryPage.setOrderBy("PSCI.CODE");
        queryPage.setSortOrder(SortOrder.ASC);
        PageList<StCdaInfo> pageList = new PageList<>();
        SqlHelper.startPage(queryPage);
        Map<String, Object> map = new TreeMap<>();
        if (!StringUtil.isNullOrWhiteSpace(key)) map.put("key", key);
        List<StCdaInfo> results = getMapper().getDataPageList(map);
        map.clear();
        map = null;
        PageInfo<StCdaInfo> pageInfo = new PageInfo<>(results);
        pageList.setTotal((int) pageInfo.getTotal());
        pageList.setRows(results);
        return pageList;
    }

    public PageList<StCdaInfo> getBySourceId(String fkSourceId, String key, QueryPage queryPage) {
        PageList<StCdaInfo> pageList = new PageList<>();
        SqlHelper.startPage(queryPage);
        Map<String, Object> map = new TreeMap<>();
        map.put("fkSourceId", fkSourceId);
        if (!StringUtil.isNullOrWhiteSpace(key)) map.put("key", key);
        List<StCdaInfo> results = getMapper().getDataPageList(map);
        map.clear();
        map = null;
        PageInfo<StCdaInfo> pageInfo = new PageInfo<>(results);
        pageList.setTotal((int) pageInfo.getTotal());
        pageList.setRows(results);
        return pageList;
    }


    public int cdaSetRsUpdate(List<StRsCdaSetInfo> infoList) throws Exception {
        return infoServiceImpl.addList(infoList);
    }


    @Override
    public List<StCdaInfo> getDataPageList(Map<String, Object> map) {
        return getMapper().getDataPageList(map);
    }

    @Override
    public int getSingle(Map<String, Object> map) {
        return getMapper().getSingle(map);
    }


    @Override
    public int add(StCdaInfo entity) throws Exception {
        Map<String, Object> map = MapUtil.createMap(m -> {
            m.put("code", entity.getCode());
        });
        if (getSingle(map) > 0) throw new BusinessException("001", entity.getCode());
        return super.add(entity);
    }

    @Override
    public int update(StCdaInfo entity) throws Exception {
        Map<String, Object> map = MapUtil.createMap(m -> {
            m.put("code", entity.getCode());
            m.put("id", entity.getId());
        });
        if (getSingle(map) > 0) throw new BusinessException("001", entity.getCode());
        return super.update(entity);
    }

    @Override
    public StCdaInfo getPrimaryKeyId(String id) {
        return getMapper().getPrimaryKeyId(id);
    }

    @Override
    public StCdaInfo getById(String id) {
        return getPrimaryKeyId(id);
    }

    public String getHtmlString(String id) throws Exception {
        StCdaInfo info = getById(id);
        if(info==null)
            throw  new BusinessException("004");

        return XmlUtil.getHtmlString(info.getSampleXml(),info.getToHtmlXsl());
    }
}