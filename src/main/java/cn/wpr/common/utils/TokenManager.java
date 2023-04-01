package cn.wpr.common.utils;

import cn.wpr.common.constant.Constant;
import cn.wpr.user.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Data
@NoArgsConstructor
public class TokenManager {




    /**
     * 创建 Token，并将 Token 存储到 Redis 中
     *
     * @param user 用户信息，用于创建 Token
     * @return 返回新创建的 Token 字符串
     */
    public static String createToken(User user) {
        // 生成一个新的 Token 字符串
        String tokenStr = Token.generateToken();

        // 生成存储 Token 所需的 Key 值
        String key = getTokenKey(tokenStr);

        // 创建一个新的 Token 对象，并设置 user 信息
        Token token = new Token(tokenStr, Constant.TOKEN_EXPIRE_SECONDS);
        token.setUser(user);
        // 将 Token 存储到 Redis 中，过期时间为指定的秒数
        RedisCacheUtil.redis.opsForValue().set(key, token, Constant.TOKEN_EXPIRE_SECONDS);

        return tokenStr;
    }

    /**
     * 验证 Token 是否有效，并刷新 Token 的过期时间
     *
     * @param tokenStr Token 字符串
     * @return 返回 Token 对应的用户信息
     */
    public static User verifyToken(String tokenStr) throws Exception {
        // 获取 Token 存储在 Redis 中的 Key 值
        String key = getTokenKey(tokenStr);

        // 从 Redis 中获取 Token 对象
        Token token = (Token)  RedisCacheUtil.redis.opsForValue().get(key);

        // 判断 Token 是否存在
        if (token == null) {
            throw new Exception("Token 不存在");
        }

        // 判断 Token 是否过期
        if (token.getExpireTime() <= 0) {
            throw new Exception("Token 已过期");
        }

        // 刷新 Token 的过期时间，单位为秒
        RedisCacheUtil.redis.opsForValue().set(key, token, Constant.TOKEN_EXPIRE_SECONDS);

        // 返回 Token 对应的用户信息
        return token.getUser();
    }


    /**
     *
     * @param tokenStr Token 字符串
     * @return 返回 Token 对应的用户信息
     */
    public static User getUser(String tokenStr) throws Exception {
        // 获取 Token 存储在 Redis 中的 Key 值
        String key = getTokenKey(tokenStr);

        // 从 Redis 中获取 Token 对象
        Token token = (Token)  RedisCacheUtil.redis.opsForValue().get(key);

        // 判断 Token 是否存在
        if (token == null) {
            throw new Exception("Token 不存在");
        }

        // 判断 Token 是否过期
        if (token.getExpireTime() <= 0) {
            throw new Exception("Token 已过期");
        }

        return token.getUser();
    }


    /**
     * 撤销指定 Token
     *
     * @param tokenStr Token 字符串
     */
    public static void revokeToken(String tokenStr) {
        // 获取 Token 存储在 Redis 中的 Key 值
        String key = getTokenKey(tokenStr);

        // 从 Redis 中删除 Token 对应的 Key 值
        RedisCacheUtil.redis.delete(key);
    }

    /**
     * 生成存储 Token 所需的 Key 值
     *
     * @param tokenStr Token 字符串
     * @return 返回 Token 存储在 Redis 时使用的 Key 值
     */
    private static String getTokenKey(String tokenStr) {
        return "token:" + tokenStr;
    }


}