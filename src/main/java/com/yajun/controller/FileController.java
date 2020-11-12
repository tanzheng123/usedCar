package com.yajun.controller;

import com.yajun.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.lang.invoke.MethodType;

@Controller
@RequestMapping("/file/")
public class FileController {

    @Autowired
    PersonalService personalService;

    /**
     * @Function: 用户图片上传
     */
    @RequestMapping(value = "/postfile")
    @ResponseBody
    public Object fileUpload(@RequestParam(value = "userImg", required = false) MultipartFile file) {
        return personalService.fileUpload(file);
    }
}
