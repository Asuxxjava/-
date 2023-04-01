package cn.wpr.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public  class RedisCacheUtil {
    @Autowired
    private RedisTemplate redisTemplate;
 
    //2.添加静态的变量
    public static RedisTemplate redis;
 
    @PostConstruct
    public void getRedisTemplate(){
        redis=this.redisTemplate;
    }
    
    //1....其他的工具方法...
}
 