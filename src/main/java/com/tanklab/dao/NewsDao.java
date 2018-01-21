package com.tanklab.dao;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;

import java.util.List;

public interface NewsDao {
    int getTableCount();

    List<News> selectNewsList();

    JDBC_STATUS updateOneNews(News news);

    JDBC_STATUS deleteOneNews(int newsId);

    JDBC_STATUS addOneNews(News news);
}
