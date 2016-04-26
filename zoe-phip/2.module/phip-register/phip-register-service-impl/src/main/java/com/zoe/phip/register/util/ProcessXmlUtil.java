package com.zoe.phip.register.util;

import com.zoe.phip.infrastructure.util.StringUtil;
import com.zoe.phip.infrastructure.util.XmlUtil;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zengjiyang on 2016/4/13.
 */
public class ProcessXmlUtil {

    private static final Logger logger = LoggerFactory.getLogger(ProcessXmlUtil.class);

    /**
     * 删除值为空的属性
     *
     * @param node
     */
    public static void deleteNullAttributes(Element node) {
        //对于叶子节点（无子节点的节点），如果含有属性但是属性值为空，则删除该属性
        if (node.elements().size() == 0 && node.attributes().size() > 0) {
            int length = node.attributes().size();
            for (int i = 0; i < length; i++) {
                if (StringUtil.isNullOrWhiteSpace(node.attributes().get(i).getValue())) {
                    node.remove(node.attributes().get(i));
                    length--;
                }
            }
        } else {
            for (Element childNode : node.elements()) {
                //递归
                deleteNullAttributes(childNode);
            }
        }
    }

    /**
     * 验证xml格式是否正确
     *
     * @param strXml
     * @return
     */
    public static String verifyMessage(String strXml) {
        Document xd;
        //校验字符串是否符合xml格式
        try {
            xd = DocumentHelper.parseText(strXml);
        } catch (DocumentException ex) {
            logger.error("error:", ex);
            return "error:传入的参数不符合xml格式。" + ex.getMessage();
        }
        String rootName = xd.getRootElement().getName();
        String xsdPath = "multicacheschemas/" + rootName + ".xsd";
        String xsdFilePath = ProcessXmlUtil.class.getClassLoader().getResource(xsdPath).getPath();
        String result = "success:数据集内容验证正确";
        String strMessage = XmlUtil.validateXsd(xsdFilePath, strXml);
        if (!strMessage.equals("")) {
            result = "error:数据集内容验证错误(" + strMessage + ")";
        }

        return result;
    }

    public static Document load(String xmlString) {
        xmlString = XmlUtil.removeNameSpace(xmlString);
        if (!xmlString.startsWith("<")) {
            xmlString = xmlString.substring(0, 1);
        }
        try {
            return DocumentHelper.parseText(xmlString);
        } catch (DocumentException ex) {
            return null;
        }
    }

}
