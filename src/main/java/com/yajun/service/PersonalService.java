package com.yajun.service;

import com.github.pagehelper.util.StringUtil;
import com.yajun.config.PreReadUploadConfig;
import com.yajun.domain.Users;
import com.yajun.result.CodeMsg;
import com.yajun.result.Result;
import com.yajun.utils.FileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonalService {

    @Autowired
    UsersService usersService;

    @Autowired
    PreReadUploadConfig preReadUploadConfig;

    /**
     * @Function: 用户图片上传
     * @param:  file 图片
     * @param:  userId 用户ID
     * @return: map
     */
    public Result fileUpload(MultipartFile file) {
        Map<String, Object> map = new HashMap<>();
        if (ObjectUtils.isEmpty(file)) {
            return Result.error(CodeMsg.FILE_EMPTY);
        }

        String fileName = file.getOriginalFilename();
        fileName = FileTool.renameToUUID(fileName);
        try {
            FileTool.uploadFiles(file.getBytes(), preReadUploadConfig.getUploadPath(), fileName);
        } catch (Exception e) {
        }
        if (ObjectUtils.isEmpty(fileName)) {
            Result.error(CodeMsg.SAVE_FILE_ERROR);
        }

        Map<String, Object> returnMap = new HashMap<>();
        String url = "/static/" + fileName;
        returnMap.put("imageUrl", url);
        return Result.success(returnMap);
    }
}
