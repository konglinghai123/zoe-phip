package com.zoe.phip.service.impl.in;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zoe.phip.dao.MyMapper;
import com.zoe.phip.model.base.PageList;
import com.zoe.phip.model.base.QueryPage;
import com.zoe.phip.model.base.ServiceResult;
import com.zoe.phip.model.base.ServiceResultT;
import com.zoe.phip.model.demo.Dept;
import com.zoe.phip.service.impl.util.SafeExecuteUtil;
import com.zoe.phip.service.in.BaseInService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by zengjiyang on 2016/3/12.
 */
public abstract class BaseInServiceImpl<T> implements BaseInService<T> {

    private static final Logger logger = LoggerFactory.getLogger(BaseInServiceImpl.class);



    @Autowired
    @SuppressWarnings("all")
    protected MyMapper<T> mapper;

    public MyMapper<T> getMapper() {
        return mapper;
    }

    @Override
    public ServiceResult add(T entity) {
        return SafeExecuteUtil.execute(logger,
                () -> mapper.insert(entity));
    }

    @Override
    public ServiceResult addList(List<T> entities) {
        return SafeExecuteUtil.execute(logger,
                () -> mapper.addList(entities));
    }

    @Override
    public ServiceResult deleteById(String id) {
        return SafeExecuteUtil.execute(logger,
                () -> mapper.deleteByPrimaryKey(id));
    }

    @Override
    public ServiceResult deleteByIds(List<String> ids) {
        return SafeExecuteUtil.execute(logger,
                () -> mapper.deleteByIds(ids));
    }

    @Override
    public ServiceResult update(T entity) {
        return  SafeExecuteUtil.execute(logger,
                () -> mapper.updateByPrimaryKeySelective(entity));
    }

    @Override
    public ServiceResult updateList(List<T> entities) {
        return SafeExecuteUtil.execute(logger,
                () -> mapper.updateList(entities));
    }

    @Override
    public ServiceResultT<T> getById(String id) {
        SafeExecuteUtil<T> safeExecute = new SafeExecuteUtil<T>();
        return safeExecute.executeT(logger, () -> mapper.selectByPrimaryKey(id));
    }

    @Override
    public ServiceResultT<List<T>> getList()
    {
        SafeExecuteUtil<List<T>> safeExecute=new SafeExecuteUtil<List<T>>();
        return safeExecute.executeT(logger,()->mapper.selectAll());
    }

    @Override
    public ServiceResultT<PageList<T>> getList(QueryPage queryPage) {
        SafeExecuteUtil<PageList<T>> safeExecute = new SafeExecuteUtil<PageList<T>>();
        return safeExecute.executeT(logger,()->
        {
            ServiceResultT<PageList<T>> resultT = new ServiceResultT<PageList<T>>();
            Example example = new Example(Dept.class);
            if (queryPage.getOrderBy() != null) {
                PageHelper.startPage(queryPage.getPageNum(), queryPage.getPageSize(), queryPage.getOrderBy());
            } else {
                PageHelper.startPage(queryPage.getPageNum(), queryPage.getPageSize());
            }
            List<T> results = mapper.selectByExample(example);
            PageInfo<T> pageInfo = new PageInfo<T>(results);
            PageList<T> pageList = new PageList<T>();
            pageList.setTotal((int) pageInfo.getTotal());
            pageList.setRows(results);
            resultT.setResult(pageList);
            return resultT;
        });
    }
}
