package com.tanklab.service;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;

import java.util.List;

public interface NewsService {
    int getTableCount();

    List<News> selectNewsList();

    JDBC_STATUS updateOneNews(News news);

    JDBC_STATUS deleteOneNews(int newsId);

    JDBC_STATUS addOneNews(News news);
}
