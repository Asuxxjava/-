package cn.wpr.user.service.impl;

import cn.wpr.user.mapper.AlbumMapper;
import cn.wpr.user.model.Album;
import cn.wpr.user.service.AlbumService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl extends ServiceImpl<AlbumMapper, Album> implements AlbumService {
}