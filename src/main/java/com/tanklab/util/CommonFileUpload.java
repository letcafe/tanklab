package com.tanklab.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class CommonFileUpload {

    public static String fileUploadPath = "\\tanklab\"uploadFile\\\\file\\\\common\"";

    static {
        fileUploadPath = System.getProperty("webDeployPath") + "..\\TanklabUploadFile";
        System.out.println("fileUploadPath:" + fileUploadPath);
    }

    public static String returnWebUrl(MultipartFile multipartFile, String typeName) throws IOException {
        String fileSuffix = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
        String fileName = typeName + "_" + System.currentTimeMillis() + fileSuffix;
        String returnWebUrl = "/TanklabUploadFile/" + typeName + "/" + fileName;
        String fileStorePath = fileUploadPath + "\\" +typeName + "\\" + fileName;

        System.out.println(fileStorePath);

        File file = new File(fileStorePath);
        if(!file.getParentFile().exists()) {//如果该文件的上级所有目录未创建，一次创建所有目录
            file.getParentFile().mkdirs();
        }
        if(!file.exists()) {//如果该文件不存在，则创建该文件
            file.createNewFile();
        }
        multipartFile.transferTo(file);//存入文件
        return returnWebUrl;
    }
}
