package cn.wpr.user.service.impl;

import cn.wpr.common.utils.TokenManager;
import cn.wpr.user.mapper.UserMapper;
import cn.wpr.user.model.User;
import cn.wpr.user.service.IUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User login(String name, String password, Model model) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, name).eq(User::getPassword, password);
        User user = this.getOne(wrapper);
        String token = TokenManager.createToken(user);
        user.setToken(token);
        return user;
    }
}