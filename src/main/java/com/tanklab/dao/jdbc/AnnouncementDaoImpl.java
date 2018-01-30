package com.tanklab.dao.jdbc;

import com.tanklab.bean.Announcement;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.AnnouncementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author yanan
 * @Desc 长期公告dao层实现类
 * @Date 2018/1/20 22:12
 */
@Repository
public class AnnouncementDaoImpl implements AnnouncementDao {
    private final static String getAnnouncement="SELECT id,title,content,date FROM announcement WHERE id=?";
    private final static String getAnnounceTopList="SELECT id,title,content,date FROM announcement ORDER BY date DESC LIMIT 0,?";
    private final static String getAnnounceList="SELECT id,title,content,date FROM announcement ORDER BY date DESC LIMIT ?,?";
    private final static String getAnnounceCount="SELECT count(0) FROM announcement";
    private final static String addAnnouncement="INSERT INTO announcement(title,content,date) VALUES(?,?,?)";
    private final static String modifyAnnouncement="UPDATE announcement SET title=?,content=?,date=? WHERE id=?";
    private final static String deleteAnnouncement="DELETE FROM announcement WHERE id=?";

    private JDBC_STATUS status = null;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public AnnouncementDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Announcement getAnnouncement(int id) {
        try {
            return jdbcTemplate.queryForObject(getAnnouncement, new AnnounceRowMapper(),id);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Announcement> getAnnounceTopList(int size) {
        try {
            return jdbcTemplate.query(getAnnounceTopList,new AnnounceRowMapper(),size);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Announcement> getAnnounceList(int start,int size) {
        try {
            return jdbcTemplate.query(getAnnounceList,new AnnounceRowMapper(),start,size);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int getAnnounceCount() {
        try {
            return jdbcTemplate.queryForObject(getAnnounceCount,Integer.class);
        } catch(EmptyResultDataAccessException e) {
            return -1;
        }
    }

    @Override
    public JDBC_STATUS addAnnouncement(Announcement announceBean) {
        try {
            jdbcTemplate.update(addAnnouncement,announceBean.getTitle(),announceBean.getContent(),announceBean.getDate());
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
