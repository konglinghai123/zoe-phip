package com.zoe.phip.service.impl.in.sm;

import com.zoe.phip.infrastructure.entity.PageList;
import com.zoe.phip.infrastructure.entity.QueryPage;
import com.zoe.phip.infrastructure.entity.SortOrder;
import com.zoe.phip.model.sm.LoginCredentials;
import com.zoe.phip.model.sm.SystemUser;
import com.zoe.phip.service.impl.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by zengjiyang on 2016/3/18.
 */
public class SystemUserServiceImplTest extends BaseTest {


    @Autowired
    private SystemUserServiceImpl systemUserService;

    @Test
    public void addTest() throws Exception {
        Map<String,String> map=new HashMap<>();
        map.put("test","1");
        map.put("Test","2");

        map.remove("test");

        System.out.println(map.size());



        SystemUser user = creteUser("管理员", "admin", "1", 1);
        int result = systemUserService.add(user);
    }

    @Test
    public void addListTest() throws Exception {
        List<SystemUser> list = new ArrayList<>();
        SystemUser user = creteUser("abc", "abc", "1", 1);
        list.add(user);
        user = creteUser("abd", "ced", "1", 1);
        list.add(user);
        int result = systemUserService.addList(list);
    }


    @Test
    public void pageQueryTest() throws Exception {
        PageList<SystemUser> resultT = systemUserService.getList(new QueryPage(1, 2), SystemUser.class);
        List<SystemUser> list = resultT.getRows();
        System.out.println(list.size());
    }

    private SystemUser creteUser(String name, String loginName, String passWord, int state) {
        SystemUser user = new SystemUser();
        user.setName(name);
        user.setLoginName(loginName);
        user.setState(state);
        user.setPassword(passWord);
        user.setCreateAt(new Date());
        user.setCreateBy(loginName);
        return user;
    }

    @Test
    public void testLogin() throws Exception {

        LoginCredentials result = systemUserService.login("admin1", "zjy", 1000 * 10);

    }

    @Test
    public void testGetUsers() throws Exception {
        PageList<SystemUser> resultT =
                systemUserService.getUserList(0, "", new QueryPage(1,30,"NAME",SortOrder.ASC));
    }

    @Test
    public void testUpdatePassword() throws Exception {
        int result = systemUserService.resetPassword("e24398fa69844859a39faa53dcbaa852", "1");
    }
}