package com.atguigu.admin.config;

import com.atguigu.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @date:2022/2/26 删除选中行ctrl+y 向下复制ctrl+d 代码自动生成alt+ins 调整代码格式ctrl+alt+l 多行缩进tab  抛异常ctrl+alt+t
 * 1.编写一个拦截器实现HandlerInterceptor接口
 * 2.拦截器注册到容器中(实现WebMvcConfigurer的addInterceptors方法)
 * 3.指定拦截器拦截规则(若果是拦截所有,静态资源也会被拦截)
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//所有请求都被拦截,包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//放行的请求
    }
}
