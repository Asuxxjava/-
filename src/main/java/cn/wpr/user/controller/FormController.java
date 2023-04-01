package cn.wpr.user.controller;

import cn.wpr.common.utils.TokenManager;
import cn.wpr.user.model.User;
import cn.wpr.user.service.IUserService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class FormController {

    @Resource
    IUserService userService;

    @GetMapping("/")
    public String index(){
        return "login";
    }
    @PostMapping("/login")
    public String submitForm(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user= userService.login(name,password,model);
        String token = TokenManager.createToken(user);
        user.setToken(token);
        model.addAttribute(user);
        Cookie cookie = new Cookie("token", user.getToken());
        cookie.setMaxAge(3600); // Cookie的有效期为1小时
        response.addCookie(cookie);
        return "index";
    }
}