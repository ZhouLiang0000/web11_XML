package com.ai.web.servlet;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

/**
 * Author：zhouliang
 * Date：2018/8/20:12:17
 * Email：18510971680@163.com
 * Description：
 */
public class TestMyServlet {
    @Test
    public void testMyServlet() {
        try {
            //1、获取解析器对象
            SAXReader saxReader = new SAXReader();
            //2、使用解析器对象加载配置文件生成Document
            Document document = saxReader.read("src/com/ai/web/servlet/web.xml");
            //3、获取跟节点
            Element rootElement = document.getRootElement();
            //4、根据元素名称servlet获取子元素节点
            Element servletElement = rootElement.element("servlet");
            //5、根据元素名称servlet-class获取子元素节点
            Element servletClass = servletElement.element("servlet-class");
            //6、获取子元素servlet-class对应的文本
            String classText = servletClass.getText();
            //7、根据类全名获取字节码文件
            Class clazz = Class.forName(classText);
            //8、生成实例对象
            MyServlet1 servlet1 = (MyServlet1) clazz.newInstance();
            //9、调用方法
            servlet1.init();
            servlet1.service();
            servlet1.destory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
