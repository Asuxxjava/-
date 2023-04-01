package cn.wpr.common.utils;

import lombok.Data;

/**
 * 分页查询类
 */
@Data
public class Query {
    /**
     * 当前页码，默认为第一页
     */
    private Integer current = 1;

    /**
     * 每页记录数，默认为10条
     */
    private Integer size = 10;

    /**
     * 升序排序字段
     */
    String aScs;

    /**
     * 降序排序字段
     */
    private String deScs;


}