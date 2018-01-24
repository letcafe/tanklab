package com.tanklab.dao.jdbc;

import com.tanklab.bean.File;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.FileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class FileDaoImpl implements FileDao {

    //定义SQL语句
    public static final String getTableCount = "SELECT COUNT(*) FROM files";

    public static final String selectFileList = "SELECT id, fileName, path, uploadTime FROM files ORDER BY uploadTime DESC";

    public static final String updateOneFile = "UPDATE files SET id = ?, fileName = ?, path = ?, uploadTime = ?";

    public static final String deleteOneFileById = "DELETE FROM files WHERE id = ?";

    public static final String addOneFile = "INSERT INTO files(fileName, path, uploadTime) VALUES(?, ?, ?)";

    //Constructor注入JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FileDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getTableCount() {
        return jdbcTemplate.queryForObject(getTableCount,Integer.class);
    }

    @Override
    public List<File> selectFileList() {
        List<File> fileList=jdbcTemplate.query(selectFileList,new FileRowMapper());
        return fileList;
    }

    @Override
    public JDBC_STATUS updateOneFile(File file) {
        return null;
    }

    @Override
    public JDBC_STATUS deleteOneFile(int fileId) {
        JDBC_STATUS status = null;
        try {
            jdbcTemplate.update(deleteOneFileById, fileId);
            status = JDBC_STATUS.SUCCESS;
        } catch (Exception ex) {
            status = JDBC_STATUS.FAIL;
        }
        return status;
    }

    @Override
    public JDBC_STATUS addOneFile(File file) {
        JDBC_STATUS status = null;
        try {
            jdbcTemplate.update(
                    addOneFile,
                    file.getFileName(),
                    file.getPath(),
                    file.getUploadTime());
            status = JDBC_STATUS.SUCCESS;
        } catch (Exception ex) {
            status = JDBC_STATUS.FAIL;
        }
        return status;
    }

    //定义内部类实现RowMapper
    private static final class FileRowMapper implements RowMapper<File> {

        @Override
        public File mapRow(ResultSet rs, int rowNum) throws SQLException {
            File file = new File();
            file.setId(rs.getInt("id"));
            file.setFileName(rs.getString("fileName"));
            file.setPath(rs.getString("path"));
            file.setUploadTime(rs.getDate("uploadTime"));
            return file;
        }
    }

}
