package com.tanklab.dao.jdbc;

import com.tanklab.bean.Notices;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.NoticesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class NoticesDaolmpl implements NoticesDao {
    private final static String getNotices="SELECT id,title,content,date FROM notices WHERE id=?";
    private final static String getNoticesTopList="SELECT id,title,content,date FROM notices ORDER BY date DESC LIMIT 0,?";
    private final static String getNoticesList="SELECT id,title,content,date FROM notices ORDER BY date DESC LIMIT ?,?";
    private final static String getNoticesCount="SELECT count(*) FROM notices";
    private final static String addNotices="INSERT INTO notices(title,content,date) VALUES(?,?,?)";
    private final static String modifyNotices="UPDATE notices SET title=?,content=?,date=? WHERE id=?";
    private final static String deleteNotices="DELETE FROM notices WHERE id=?";

    private JDBC_STATUS status = null;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public NoticesDaolmpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Notices getNotices(int id) {
        try {
            return jdbcTemplate.queryForObject(getNotices, new NoticesDaolmpl.NoticesRowMapper(),id);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Notices> getNoticesTopList(int size) {
        try {
            return jdbcTemplate.query(getNoticesTopList,new NoticesDaolmpl.NoticesRowMapper(),size);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    @Override
    public List<Notices> getNoticesList(int start,int size) {
        try {
            return jdbcTemplate.query(getNoticesList,new NoticesDaolmpl.NoticesRowMapper(),start,size);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int getNoticesCount() {
        try {
            return jdbcTemplate.queryForObject(getNoticesCount,Integer.class);
        } catch(EmptyResultDataAccessException e) {
            return -1;
        }
    }

    @Override
    public JDBC_STATUS addNotices(Notices noticesBean) {
        try {
            jdbcTemplate.update(addNotices,noticesBean.getTitle(),noticesBean.getContent(),noticesBean.getDate());
            status=JDBC_STATUS.SUCCESS;
        } catch(EmptyResultDataAccessException e) {
            status=JDBC_STATUS.ERROR;
        }
        return status;

    }

    @Override
    public JDBC_STATUS modifyNotices(Notices noticesBean) {
        try {
            jdbcTemplate.update(modifyNotices,noticesBean.getTitle(),noticesBean.getContent(),noticesBean.getDate(),noticesBean.getId());
            status=JDBC_STATUS.SUCCESS;
        } catch(EmptyResultDataAccessException e) {
            status=JDBC_STATUS.ERROR;
        }
        return status;
    }

    @Override
    public JDBC_STATUS deleteNotices(int id) {
        try {
            jdbcTemplate.update(deleteNotices,id);
            status=JDBC_STATUS.SUCCESS;
        } catch(EmptyResultDataAccessException e) {
            status=JDBC_STATUS.ERROR;
        }
        return status;
    }

    private static final class NoticesRowMapper implements RowMapper<Notices> {

        @Override
        public Notices mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String content = rs.getString("content");
            Date date = rs.getDate("date");
            Notices notices = new Notices(id,title,content,date);
            return notices;
        }
    }


}
