package com.tanklab.service.implService;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;
import com.tanklab.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements com.tanklab.service.NewsService {

    private NewsDao newsDao;

    @Autowired
    public NewsServiceImpl(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @Override
    public int getTableCount() {
        return newsDao.getTableCount();
    }

    @Override
    public List<News> selectNewsList() {
        return newsDao.selectNewsList();
    }

    @Override
    public JDBC_STATUS updateOneNews(News news) {
        return newsDao.updateOneNews(news);
    }

    @Override
    public JDBC_STATUS deleteOneNews(int newsId) {
        return newsDao.deleteOneNews(newsId);
    }

    @Override
    public JDBC_STATUS addOneNews(News news) {
        return newsDao.addOneNews(news);
    }
}
