package com.tanklab.service;

import com.tanklab.bean.File;
import com.tanklab.bean.JDBC_STATUS;

import java.util.List;
import java.util.Map;

public interface FileService {
    int getTableCount();

    List<File> selectFileList();

    File selectDetailedFile(int id);

    List<File> selectMany(int startIndex, int size);

    JDBC_STATUS updateOneFile(File file);

    JDBC_STATUS deleteOneFile(int fileId);

    JDBC_STATUS addOneFile(File file);

    Map<String,String> getSuffixes(List<File> fileList);
}