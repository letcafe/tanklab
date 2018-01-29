package com.tanklab.service.implService;

import com.tanklab.bean.File;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.FileDao;
import com.tanklab.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    private FileDao fileDao;

    @Autowired
    public FileServiceImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public int getTableCount() {
        return fileDao.getTableCount();
    }

    @Override
    public List<File> selectFileList() {
        return fileDao.selectFileList();
    }

    @Override
    public File selectDetailedFile(int id) {
        return fileDao.selectDetailedFile(id);
    }

    @Override
    public List<File> selectMany(int startIndex, int size) {
        return fileDao.selectMany(startIndex, size);
    }

    @Override
    public JDBC_STATUS updateOneFile(File file) {
        return fileDao.updateOneFile(file);
    }

    @Override
    public JDBC_STATUS deleteOneFile(int fileId) {
        return fileDao.deleteOneFile(fileId);
    }

    @Override
    public JDBC_STATUS addOneFile(File file) {
        return fileDao.addOneFile(file);
    }
}
