package com.tanklab.dao.jdbc;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class NewsDaoImpl implements com.tanklab.dao.NewsDao {

    //定义SQL语句
    public static final String getTableCount = "SELECT COUNT(*) FROM news";

    public static final String selectNewsList = "SELECT id, title, content, date, imgUrl FROM news ORDER BY date DESC";

    public static final String updateOneNews = "UPDATE news SET id = ?, title = ?, content = ?, date = ?, imgUrl = ?";

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
    public List<News> selectNewsList() {
        List<News> newsList = jdbcTemplate.query(
                selectNewsList,
                new NewsRowMapper());
        return newsList;
    }

    @Override
    public JDBC_STATUS updateOneNews(News news) {
        return null;
    }

    @Override
    public JDBC_STATUS deleteOneNews(int newsId) {
        return null;
    }

    @Override
    public JDBC_STATUS addOneNews(News news) {
        return null;
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