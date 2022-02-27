package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Fruit;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.impl.FruitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @date:2022/2/26 删除选中行ctrl+y 向下复制ctrl+d 代码自动生成alt+ins 调整代码格式ctrl+alt+l 多行缩进tab  抛异常ctrl+alt+t
 */
@Controller
public class IndexController {
    @Autowired
    FruitServiceImpl fruitService;

    @ResponseBody
    @GetMapping("fruit")
    public Fruit getFruit(@RequestParam("fid") Integer fid) {
        return fruitService.getFruitById(fid);
    }

    //登录页
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (!StringUtils.isEmpty(user.getUserName()) && "123".equals(user.getPassword())) {
            //把登陆成功的用户保存起来
            session.setAttribute("loginUser", user);
            //登陆成功,重定向到main.html    重定向防止表单重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "登陆失败");
            //回到登录页
            return "login";
        }
    }

    //去main页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
//        //判断是否登录    拦截器\过滤器
//        Object loginUser = session.getAttribute("loginUser");
//        if (loginUser!=null){
//            return "main";
//        }else {
//            model.addAttribute("msg","登陆失败");
//            return "login";
//        }
        return "main";
    }
}
