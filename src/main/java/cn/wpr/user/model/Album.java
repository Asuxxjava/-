package cn.wpr.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Album  implements Serializable {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 图片地址
     */
    @TableField("file_url")
    private String fileUrl;

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 是否已删除
     */
    @TableField("is_delete")
    private Integer isDelete;

    /**
     * 相册名字
     */
    @TableField("prc_name")
    private String prcName;

}