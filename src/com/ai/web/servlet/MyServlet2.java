package com.ai.web.servlet;

/**
 * Author：zhouliang
 * Date：2018/8/20:12:14
 * Email：18510971680@163.com
 * Description：
 */
public class MyServlet2 implements IMyServlet {
    @Override
    public void init() {
        System.out.println("啊，俺来也2----");
    }

    @Override
    public void service() {
        System.out.println("啊，俺可以为你服务2----");

    }

    @Override
    public void destory() {
        System.out.println("啊，俺去也2----");

    }
}
