package cn.wpr.user.controller;

import cn.wpr.common.utils.DataUtils;
import cn.wpr.common.utils.Query;
import cn.wpr.common.utils.R;
import cn.wpr.user.model.User;
import cn.wpr.user.service.IUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @PostMapping("/login")
    public User submitForm(@RequestParam("name") String name, @RequestParam("password") String password, Model model, HttpServletResponse response) {
        User user= userService.login(name,password,model);
        model.addAttribute(user);
        Cookie cookie = new Cookie("token", user.getToken());
        cookie.setMaxAge(3600); // Cookie的有效期为1小时
        response.addCookie(cookie);
        return user;
    }
    @GetMapping("/list")
    public R<IPage<User>> list(Query query){
        return R.data(userService.page(DataUtils.page(query)));
    }

    @PostMapping
    public boolean add(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping
    public boolean update(@RequestBody User user) {
        return userService.updateById(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {
        return userService.removeById(id);
    }
}