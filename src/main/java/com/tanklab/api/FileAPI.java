package com.tanklab.api;

import com.tanklab.bean.File;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.RestMessage;
import com.tanklab.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/api/v1/file")
public class FileAPI {

    private FileDao fileDao;

    @Autowired
    public FileAPI(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    //return file count
    @RequestMapping(value = "/count", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage getFileCount() {
        RestMessage<Integer> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(fileDao.getTableCount());
        return restMessage;
    }

    //select all files
    @RequestMapping(value = "", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage<List<File>> getAllFiles() {
        RestMessage<List<File>> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(fileDao.selectFileList());
        return restMessage;
    }

    //add one file
    @RequestMapping(value = "", method = POST, produces = "application/json")
    @ResponseBody
    public RestMessage<File> addOneFile(
            @RequestParam(value = "fileName") String fileName,
            @RequestParam(value = "path") MultipartFile path) throws IOException {
        String destFileLocation = "E:\\\\tmp\\" + path.getOriginalFilename();//上传的文件路径
        java.io.File destFile = new java.io.File(destFileLocation);
        path.transferTo(destFile);
//        File file = new File(fileName, "file_" + System.currentTimeMillis()+"_"+path, new Date());
//        fileDao.addOneFile(file);
//        RestMessage<File> restMessage = new RestMessage();
//        restMessage.setCode(200);
//        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
//        restMessage.setData(null);
        return null;
    }

    //delete all files
    @RequestMapping(value = "", method = DELETE, produces = "application/json")
    @ResponseBody
    public RestMessage<String> deleteOneFile(@RequestParam(value = "id") String id) {
        fileDao.deleteOneFile(Integer.valueOf(id));
        RestMessage<String> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

    //update all file
    @RequestMapping(value = "", method = PUT, produces = "application/json")
    @ResponseBody
    public RestMessage<String> updateOneFile(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "fileName") String fileName,
            @RequestParam(value = "path") MultipartFile path,
            @RequestParam(value = "uploadTime") Date uploadTime) {
        File file = new File(id, fileName, "file_" + System.currentTimeMillis()+"_"+path, uploadTime);
        fileDao.updateOneFile(file);
        RestMessage<String> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

}

