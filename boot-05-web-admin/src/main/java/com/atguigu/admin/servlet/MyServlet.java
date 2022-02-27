package com.atguigu.admin.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @date:2022/2/27 删除选中行ctrl+y 向下复制ctrl+d 代码自动生成alt+ins 调整代码格式ctrl+alt+l 多行缩进tab  抛异常ctrl+alt+t
 */
//@WebServlet(urlPatterns = "/my")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("ThisIsWebServletsDoGet()");
    }
}
