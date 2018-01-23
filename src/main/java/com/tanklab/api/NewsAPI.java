package com.tanklab.api;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;
import com.tanklab.bean.RestMessage;
import com.tanklab.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/api/v1/news")
public class NewsAPI {

    private NewsService newsService;

    @Autowired
    public NewsAPI(NewsService newsService) {
        this.newsService = newsService;
    }

    //return news count
    @RequestMapping(value = "/count", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage getNewsCount() {
        RestMessage<Integer> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(newsService.getTableCount());
        return restMessage;
    }

    //select all news
    @RequestMapping(value = "", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage<List<News>> getAllNews() {
        RestMessage<List<News>> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(newsService.selectNewsList());
        return restMessage;
    }

    //add one news
    @RequestMapping(value = "", method = POST, produces = "application/json")
    @ResponseBody
    public RestMessage<News> addOneNews(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "date") Date date,
            @RequestParam(value = "file") MultipartFile file) throws IOException {
        String destFileLocation = "E:\\\\tmp\\" + file.getOriginalFilename();//上传的文件路径
        File destFile = new File(destFileLocation);
        file.transferTo(destFile);
        News news = new News(title, content, date, "news_" + System.currentTimeMillis());
        newsService.addOneNews(news);
        RestMessage<News> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

    //delete all news
    @RequestMapping(value = "", method = DELETE, produces = "application/json")
    @ResponseBody
    public RestMessage<String> deleteOneNews(@RequestParam(value = "id") String id) {
        newsService.deleteOneNews(Integer.valueOf(id));
        RestMessage<String> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

    //update all news
    @RequestMapping(value = "", method = PUT, produces = "application/json")
    @ResponseBody
    public RestMessage<String> updateOneNews(
        @RequestParam(value = "id") int id,
        @RequestParam(value = "title") String title,
        @RequestParam(value = "content") String content,
        @RequestParam(value = "date") Date date,
        @RequestParam(value = "imgUrl") MultipartFile imgUrl) {
            News news = new News(id, title, content, date, "news_" + System.currentTimeMillis());
            newsService.updateOneNews(news);
            RestMessage<String> restMessage = new RestMessage();
            restMessage.setCode(200);
            restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
            restMessage.setData(null);
            return restMessage;
    }

}
