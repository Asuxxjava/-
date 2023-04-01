package cn.wpr.user.controller;

import cn.wpr.common.utils.R;
import cn.wpr.system.service.IOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    private IOssService ossService;

    @PostMapping("/upload")
    public R<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        String result = ossService.uploadFileAvatar(file);

        return R.data(result);
    }
}
