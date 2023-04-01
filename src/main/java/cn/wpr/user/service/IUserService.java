package cn.wpr.user.service;

import cn.wpr.user.model.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.ui.Model;

public interface IUserService extends IService<User> {
    User login(String name, String password, Model model);
}