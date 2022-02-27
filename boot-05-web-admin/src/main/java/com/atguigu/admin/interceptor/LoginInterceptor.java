package com.atguigu.admin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @date:2022/2/26 删除选中行ctrl+y 向下复制ctrl+d 代码自动生成alt+ins 调整代码格式ctrl+alt+l 多行缩进tab  抛异常ctrl+alt+t
 */
public class LoginInterceptor implements HandlerInterceptor {//登陆检查
    //1.配置好拦截器要拦截哪些请求
    //2.把这些配置放在容器中
    @Override//目标方法执行之前
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆检查逻辑
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            return true;//放行
        }
        //拦截住  未登录,跳转到登录页
        session.setAttribute("msg","登陆失败");
        response.sendRedirect("/");
        return false;
    }

    @Override//目标方法完成之后
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override//页面渲染之后
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
