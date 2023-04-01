package cn.wpr.common.utils;

import cn.wpr.common.utils.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

public class DataUtils {


    /**
     将 Query 对象转换为 MyBatis Plus 的 Page 对象
     @return MyBatis Plus 的 Page 对象
     */
    public static IPage page(Query query) {
        Page page = new Page<>(query.getCurrent(), query.getSize());
        QueryWrapper wrapper = new QueryWrapper();
        if (query.aScs != null) {
            wrapper.orderByAsc(query.aScs);
        }
        if (query.getDeScs() != null) {
            wrapper.orderByDesc(query.getDeScs());
        }
        return page;
    }
}
