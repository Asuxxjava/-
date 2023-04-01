package cn.wpr.common.utils;

import jdk.nashorn.internal.ir.annotations.Reference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
@NoArgsConstructor
@AllArgsConstructor
public class RedisUtils {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 存储一个 Key-Value 对，并设置过期时间
     *
     * @param key    键值
     * @param value  对应值
     * @param expire 过期秒数
     */
    public void set(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    /**
     * 获取指定 Key 对应的值
     *
     * @param key 键值
     * @return 对应的值
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除指定 Key 对应的 Key-Value 对
     *
     * @param key 键值
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}
