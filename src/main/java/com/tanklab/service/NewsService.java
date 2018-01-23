package com.tanklab.service;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;

import java.util.List;

public interface NewsService {
    int getTableCount();

    List<News> selectNewsList();

    News selectDetailedNews(int id);

    List<News> selectMany(int startIndex, int size);

    JDBC_STATUS updateOneNews(News news);

    JDBC_STATUS deleteOneNews(int newsId);

    JDBC_STATUS addOneNews(News news);
}
