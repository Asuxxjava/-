package cn.wpr.common.utils;

import cn.wpr.user.model.User;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Token {

    private String token;
    // 设置token的过期时间，单位为秒
    private int expireTime;

    private User user;

    public Token(String token, int expireTime) {
        this.token = token;
        this.expireTime = expireTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    public static String generateToken() {
        // 使用 UUID 生成 Token
        String token = UUID.randomUUID().toString().replace("-", "");
        return token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}