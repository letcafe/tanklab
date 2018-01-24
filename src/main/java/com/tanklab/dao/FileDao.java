package com.tanklab.dao;

import com.tanklab.bean.File;
import com.tanklab.bean.JDBC_STATUS;

import java.util.List;

public interface FileDao {
    int getTableCount();

    List<File> selectFileList();

    JDBC_STATUS updateOneFile(File file);

    JDBC_STATUS deleteOneFile(int fileId);

    JDBC_STATUS addOneFile(File file);
}
