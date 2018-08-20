package com.ai.web.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * Author：zhouliang
 * Date：2018/8/20:10:43
 * Email：18510971680@163.com
 * Description：Dom4j解析测试类
 */
public class TestDom4j {
    @Test
    public void testReadWebXml() {
        try {
            //1、获取解析器
            SAXReader reader = new SAXReader();
            //2、获得document对象
            Document document = reader.read("src/com/ai/web/schema/web.xml");
            //3、获取rootDocument对象
            Element rootElement = document.getRootElement();
//            System.out.println(rootElement.getName());//获取跟元素节点
//            System.out.println(rootElement.attributeValue("version"));//获取跟元素节点属性值
            //4、获取子元素集合
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                if ("servlet".equals(element.getName())) {
                    Element servletName = element.element("servlet-name");
                    Element servletClass = element.element("servlet-class");
                    System.out.println(servletName.getText());
                    System.out.println(servletClass.getText());
                } else if ("servlet-mapping".equals(element.getName())) {
                    Element servletName = element.element("servlet-name");
                    Element urlName = element.element("url-pattern");
                    System.out.println(servletName.getText());
                    System.out.println(urlName.getText());
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
