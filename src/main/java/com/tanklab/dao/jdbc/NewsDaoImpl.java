package com.tanklab.dao.jdbc;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;
import com.tanklab.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {

    //定义SQL语句
    public static final String getTableCount = "SELECT COUNT(*) FROM news";

    public static final String selectDetailedNews = "SELECT id, title, content, date, imgUrl FROM news WHERE id = ?";

    public static final String selectNewsList = "SELECT id, title, content, date, imgUrl FROM news ORDER BY date DESC";

    public static final String selectBetween = "SELECT id, title, content, date, imgUrl FROM news ORDER BY date DESC LIMIT ?, ?";

    public static final String updateOneNewsWithImg = "UPDATE news SET id = ?, title = ?, content = ?, date = ?, imgUrl = ? WHERE id = ?";

    public static final String updateOneNewsWithoutImg = "UPDATE news SET id = ?, title = ?, content = ?, date = ? WHERE id = ?";

    public static final String deleteOneNewsById = "DELETE FROM news WHERE id = ?";

    public static final String addOneNews = "INSERT INTO news(title, content, date, imgUrl) VALUES(?, ?, ?, ?)";

    //Constructor注入JdbcTemplate
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //执行JDBC操作
    @Override
    public int getTableCount() {
        return jdbcTemplate.queryForObject(getTableCount, Integer.class);
    }

    @Override
    public News selectDetailedNews(int id) {
        return jdbcTemplate.queryForObject(selectDetailedNews, new NewsRowMapper(), id);
    }

    @Override
    public List<News> selectNewsList() {
        return jdbcTemplate.query(selectNewsList, new NewsRowMapper());
    }

    @Override
    public List<News> selectMany(int startIndex, int size) {
        return jdbcTemplate.query(selectBetween, new NewsRowMapper(), startIndex, size);
    }

    @Override
    public JDBC_STATUS updateOneNews(News news) {
        JDBC_STATUS status = null;
        try {
            if(news.getImgUrl() != null) {
                jdbcTemplate.update(updateOneNewsWithImg,
                        news.getId(),
                        news.getTitle(),
                        news.getContent(),
                        news.getDate(),
                        news.getImgUrl(),
                        news.getId());
            } else {
                jdbcTemplate.update(updateOneNewsWithoutImg,
                        news.getId(),
                        news.getTitle(),
                        news.getContent(),
                        news.getDate(),
                        news.getId());
            }
            status = JDBC_STATUS.SUCCESS;
        } catch (Exception ex) {
            status = JDBC_STATUS.FAIL;
        }
        return status;
    }

    @Override
    public JDBC_STATUS deleteOneNews(int newsId) {
        JDBC_STATUS status = null;
        try {
            jdbcTemplate.update(deleteOneNewsById, newsId);
            status = JDBC_STATUS.SUCCESS;
        } catch (Exception ex) {
            status = JDBC_STATUS.FAIL;
        }
        return status;
    }

    @Override
    public JDBC_STATUS addOneNews(News news) {
        JDBC_STATUS status = null;
        try {
            jdbcTemplate.update(
                    addOneNews,
                    news.getTitle(),
                    news.getContent(),
                    news.getDate(),
                    news.getImgUrl());
            status = JDBC_STATUS.SUCCESS;
        } catch (Exception ex) {
            status = JDBC_STATUS.FAIL;
        }
        return status;
    }

    //定义内部类实现RowMapper
    private static final class NewsRowMapper implements RowMapper<News> {

        @Override
        public News mapRow(ResultSet rs, int rowNum) throws SQLException {
            News news = new News();
            news.setId(rs.getInt("id"));
            news.setTitle(rs.getString("title"));
            news.setContent(rs.getString("content"));
            news.setDate(rs.getDate("date"));
            news.setImgUrl(rs.getString("imgUrl"));
            return news;
        }
    }

}
