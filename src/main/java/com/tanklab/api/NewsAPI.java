package com.tanklab.api;

import com.tanklab.bean.News;
import com.tanklab.bean.RestMessage;
import com.tanklab.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/api/v1/news")
public class NewsAPI {

    private NewsDao newsDao;

    @Autowired
    public NewsAPI(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    //return news count
    @RequestMapping(value = "/count", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage getNewsCount() {
        RestMessage<Integer> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg("success");
        restMessage.setData(newsDao.getTableCount());
        return restMessage;
    }

    //select all news
    @RequestMapping(value = "/allList", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage<List<News>> getAllNews() {
        RestMessage<List<News>> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg("success");
        restMessage.setData(newsDao.selectNewsList());
        return restMessage;
    }

    //add one news
    @RequestMapping(value = "/", method = POST, produces = "application/json")
    @ResponseBody
    public RestMessage<News> addOneNews(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "date") Date date,
            @RequestParam(value = "imgUrl") CommonsMultipartFile imgUrl) {
        News news = new News();
        newsDao.addOneNews(news);
        RestMessage<News> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg("success");
        restMessage.setData(news);
        return restMessage;
    }

    //delete all news
    @RequestMapping(value = "/", method = DELETE, produces = "application/json")
    @ResponseBody
    public RestMessage<String> deleteOneNews(@RequestParam(value = "id") String id) {
        newsDao.deleteOneNews(Integer.valueOf(id));
        RestMessage<String> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg("success");
        restMessage.setData("delete one news successfully");
        return restMessage;
    }

    //update all news
    @RequestMapping(value = "/", method = PUT, produces = "application/json")
    @ResponseBody
    public RestMessage<String> updateOneNews(
        @RequestParam(value = "title") String title,
        @RequestParam(value = "content") String content,
        @RequestParam(value = "date") Date date,
        @RequestParam(value = "imgUrl") CommonsMultipartFile imgUrl) {
            News news = new News();
            newsDao.updateOneNews(news);
            RestMessage<String> restMessage = new RestMessage();
            restMessage.setCode(200);
            restMessage.setMsg("success");
            restMessage.setData("update one news successfully");
            return restMessage;
    }

}