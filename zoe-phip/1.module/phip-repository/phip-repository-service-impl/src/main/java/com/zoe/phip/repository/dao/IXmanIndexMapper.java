package com.zoe.phip.repository.dao;

import com.zoe.phip.module.service.mapper.IServiceMapper;
import com.zoe.phip.repository.model.XmanIndex;

import java.util.Map;

/**
 * Created by zengjiyang on 2016/5/6.
 */
public interface IXmanIndexMapper extends IServiceMapper<XmanIndex> {
    String getXmanId(Map<String, Object> args);

    XmanIndex documentRegistryQuery(Map<String, Object> paras);

    /**
     *  获取文档信息
     * @param paras
     * @return
     */
    XmanIndex getDocumentInfo(Map<String, Object> paras);
    
}
