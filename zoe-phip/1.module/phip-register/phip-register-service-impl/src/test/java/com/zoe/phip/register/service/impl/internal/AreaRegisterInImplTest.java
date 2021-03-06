package com.zoe.phip.register.service.impl.internal;

import com.alibaba.fastjson.JSON;
import com.zoe.phip.infrastructure.entity.PageList;
import com.zoe.phip.infrastructure.entity.QueryPage;
import com.zoe.phip.register.BaseTest;
import com.zoe.phip.register.model.AreaBaseInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by zhangwenbin on 2016/4/28.
 */
public class AreaRegisterInImplTest extends BaseTest {

    @Autowired
    private AreaRegisterInImpl impl;

    @Test
    public void add() throws Exception {

        AreaBaseInfo baseInfo = new AreaBaseInfo();
        baseInfo.setId(UUID.randomUUID().toString());
        baseInfo.setCode("86");
        baseInfo.setName("中国人民共和国");
        baseInfo.setBuildTime(new Date());
        baseInfo.setAreaCancellationDate(new Date());
        impl.add(baseInfo);
    }

    @Test
    public void query() throws Exception {


        PageList<AreaBaseInfo> result = impl.getAreaChildrenRegistry("cdd9be10-7077-463c-b764-eba040de904c", "351000", new QueryPage());
        System.out.println(JSON.toJSON(result));
    }

}