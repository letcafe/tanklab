package com.tanklab.api;

import com.tanklab.bean.File;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.RestMessage;
import com.tanklab.dao.FileDao;
import com.tanklab.service.FileService;
import com.tanklab.util.CommonFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/api/v1/file")
public class FileAPI {

    private FileService fileService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    public FileAPI(FileService fileService) {
        this.fileService = fileService;
    }

    //return file count
    @RequestMapping(value = "/count", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage getFileCount() {
        RestMessage<Integer> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(fileService.getTableCount());
        return restMessage;
    }

    //select all files
    @RequestMapping(value = "", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage<List<File>> getAllFiles() {
        RestMessage<List<File>> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(fileService.selectFileList());
        return restMessage;
    }

    //add one file
    @RequestMapping(value = "", method = POST, produces = "application/json")
    @ResponseBody
    public RestMessage<File> addOneFile(
            @RequestParam(value = "fileName") String fileName,
            @RequestParam(value = "path") MultipartFile path,
            @RequestParam(value="uploadTime")String uploadTime ) throws IOException ,ParseException {

        RestMessage<File> restMessage = new RestMessage();

        //判断文件大小
        if(path.getSize() > 200 * 1024 *1024) {//如果文件大于200M，返回失败提示
            restMessage.setCode(213);
            restMessage.setMsg("error:add file out of 200MB");
            restMessage.setData(null);
            return  restMessage;
        }


        String destWebUrl = CommonFileUpload.returnWebUrl(path, "file");

        //插入数据库
        File file = new File(fileName, destWebUrl, sdf.parse(uploadTime));
        System.out.println(file.toString());
        fileService.addOneFile(file);

        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

    //delete all files
    @RequestMapping(value = "", method = DELETE, produces = "application/json")
    @ResponseBody
    public RestMessage<String> deleteOneFile(@RequestParam(value = "id") int id) {
        fileService.deleteOneFile(id);
        RestMessage<String> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

    //update one file
    @RequestMapping(value = "/change", method = POST, produces = "application/json")
    @ResponseBody
    public RestMessage<File> updateOneFile(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "fileName") String fileName,
            @RequestParam(value = "path",required = false) MultipartFile path,
            @RequestParam(value="uploadTime")String uploadTime ) throws IOException, ParseException {
        System.out.println("path:" + path);
        RestMessage<File> restMessage = new RestMessage();
        if(path != null) {
            //上传文件
            if(path.getSize() > 200 * 1024 *1024) {//如果文件大于200M，返回失败提示
                restMessage.setCode(213);
                restMessage.setMsg("error:change file out of 200MB");
                restMessage.setData(null);
                return  restMessage;
            }
            String destWebUrl = CommonFileUpload.returnWebUrl(path, "file");
            //更新数据库
            System.out.println("run post file:" + destWebUrl);
            File file = new File(id,fileName,destWebUrl,sdf.parse(uploadTime));//如果用户没有更新图片，执行带imgUrl的SQL
            fileService.updateOneFile(file);
        } else {
            File file = new File(id, fileName,null,sdf.parse(uploadTime));//如果用户没有更新图片，执行不带imgUrl的SQL
            fileService.updateOneFile(file);
        }
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

}

