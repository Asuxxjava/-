package cn.wpr.common.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
 
@Component
@ConfigurationProperties(prefix = "oss")
public class ConstantPropertiesUtils implements InitializingBean {
 
    //读取配置文件的内容
    @Value("${oss.endpoint}")
    private String endpoint;
    @Value("${oss.accessKeyId}")
    private String keyId;
    @Value("${oss.accessKeySecret}")
    private String keySecret;
    @Value("${oss.bucketName}")
    private String bucketName;
 
    //定义公共静态常量
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
 
    @Override
    public void afterPropertiesSet() throws Exception {
        END_POINT = endpoint;
        ACCESS_KEY_ID = keyId;
        ACCESS_KEY_SECRET = keySecret;
        BUCKET_NAME = bucketName;
    }
}