package cn.wpr.system.controller;

import cn.wpr.system.service.IOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
 
@RestController("/file")
public class OssController {
 
    @Autowired
    private IOssService ossService;
 
    //上传头像，返回图片的url给
    @PostMapping("/upload")
    public String uploadOssFile(MultipartFile file) throws Exception{
        //获取上传文件 MultipartFile
        //返回图片在oss上的路径
        return ossService.uploadFileAvatar(file);
    }
 
}