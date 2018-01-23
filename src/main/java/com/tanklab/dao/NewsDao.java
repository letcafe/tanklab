package com.tanklab.dao;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;

import java.util.List;

public interface NewsDao {
    int getTableCount();

    News selectDetailedNews(int id);

    List<News> selectNewsList();

    List<News> selectMany(int startIndex, int size);

    JDBC_STATUS updateOneNews(News news);

    JDBC_STATUS deleteOneNews(int newsId);

    JDBC_STATUS addOneNews(News news);

}
