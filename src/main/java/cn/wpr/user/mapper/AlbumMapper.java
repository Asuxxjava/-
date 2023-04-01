package cn.wpr.user.mapper;

import cn.wpr.user.model.Album;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlbumMapper extends BaseMapper<Album> {
}