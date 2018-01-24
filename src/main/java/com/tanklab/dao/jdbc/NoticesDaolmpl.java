package com.tanklab.dao.jdbc;

import com.tanklab.bean.Notices;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.NoticesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class NoticesDaolmpl implements NoticesDao {
    private final static String getNotices="SELECT id,title,content,date FROM notices WHERE id=?";
    private final static String getNoticesTopList="SELECT id,title,content,date FROM notices ORDER BY id DESC LIMIT 0,?";
    private final static String getNoticesList="SELECT id,title,content,date FROM notices ORDER BY id DESC LIMIT ?,?";
    private final static String getNoticesCount="SELECT count(0) FROM notices";
    private final static String addNotices="INSERT INTO notices(title,content,date) VALUES(?,?,?)";
    private final static String modifyNotices="UPDATE notices SET title=?,content=?,date=? WHERE id=?";
    private final static String deleteNotices="DELETE FROM notices WHERE id=?";

    private JDBC_STATUS status = null;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public NoticesDaoImpl(JdbcTemplate jdbcTemplate) {
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
e
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
    public JDBC_STATUS modifyAnnouncement(Announcement announceBean) {
        try {
            jdbcTemplate.update(modifyAnnouncement,announceBean.getTitle(),announceBean.getContent(),announceBean.getDate(),announceBean.getId());
            status=JDBC_STATUS.SUCCESS;
        } catch(EmptyResultDataAccessException e) {
            status=JDBC_STATUS.ERROR;
        }
        return status;
    }

    @Override
    public JDBC_STATUS deleteAnnouncement(int id) {
        try {
            jdbcTemplate.update(deleteAnnouncement,id);
            status=JDBC_STATUS.SUCCESS;
        } catch(EmptyResultDataAccessException e) {
            status=JDBC_STATUS.ERROR;
        }
        return status;
    }

    private static final class AnnounceRowMapper implements RowMapper<Announcement> {

        @Override
        public Announcement mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String content = rs.getString("content");
            Date date = rs.getDate("date");
            Announcement announce = new Announcement(id,title,content,date);
            return announce;
        }
    }


}
