package cn.wpr.user.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("w_user")
public class User {
    private Long id;
    private String nikeName;
    private String username;
    private String password;
    private String headSculpture;
    private Date createTime;
    private Date updateTime;
    private Integer age;
    @TableField(exist = false)
    private String token;
}