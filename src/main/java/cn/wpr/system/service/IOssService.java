package cn.wpr.system.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IOssService {
    String uploadFileAvatar(MultipartFile file) throws IOException;
}
