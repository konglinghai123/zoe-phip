package com.zoe.phip.web.context;

import com.zoe.phip.infrastructure.config.PropertyPlaceholder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by linqinghuang on 2016/4/11.
 */
public class UrlExpand {

    public static String staticPath= PropertyPlaceholder.getProperty("static-web.url");
    public static String webRoot=PropertyPlaceholder.getProperty("web.url");
    public static String versionValue=PropertyPlaceholder.getProperty("web.version");

    //设置静态资源路径，
    public static String SetStaticRoot(String filePath) {
        String version = UrlExpand.GetVersion();
        String staticResourcePath = staticPath;//此静态资源路径从配置文件中获取
//        staticResourcePath += "/";
        return staticResourcePath + filePath + "?Version=" + version;
    }

    public static String SetWebRoot(String filePath) {
        String version = UrlExpand.GetVersion();
        // TODO: 2016/4/11
        String webResourcePath = "";//获取根目录
        webResourcePath += "/";
        return webResourcePath + filePath + "?Version=" + version;
    }

    public static String GetVersion() {
        // TODO: 2016/4/11
        String version = versionValue;//此version 从配置中获取
        if (version == null || version.equals("")) {
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
            version = dateFormat.format(now);
        }
        return version;
    }
}
