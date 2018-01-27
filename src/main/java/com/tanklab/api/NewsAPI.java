package com.tanklab.api;

import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.News;
import com.tanklab.bean.RestMessage;
import com.tanklab.service.NewsService;
import com.tanklab.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/api/v1/news")
public class NewsAPI {

    private NewsService newsService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
            @RequestParam(value = "date") String date,
            @RequestParam(value = "imgUrl") MultipartFile imgUrl) throws IOException, ParseException {
        RestMessage<News> restMessage = new RestMessage();
        //上传文件
        if(imgUrl.getSize() > 5 * 1024 *1024) {//如果文件大于5M，返回失败提示
            restMessage.setCode(213);
            restMessage.setMsg("error:add pic out of 5MB");
            restMessage.setData(null);
            return  restMessage;
        }
        String destWebUrl = FileUpload.returnWebUrl(imgUrl, "news");

        //插入数据库
        News news = new News(title, content, sdf.parse(date), destWebUrl);
        System.out.println(news.toString());
        newsService.addOneNews(news);

        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

    //delete all news
    @RequestMapping(value = "", method = DELETE, produces = "application/json")
    @ResponseBody
    public RestMessage<String> deleteOneNews(@RequestParam(value = "id") int id) {
        newsService.deleteOneNews(id);
        RestMessage<String> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

    //update one news
    @RequestMapping(value = "/change", method = POST, produces = "application/json")
    @ResponseBody
    public RestMessage<News> updateOneNews(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "date") String date,
            @RequestParam(value = "imgUrl", required = false) MultipartFile imgUrl) throws IOException, ParseException {
        System.out.println("imgUrl:" + imgUrl);
        RestMessage<News> restMessage = new RestMessage();
        if(imgUrl != null) {
            //上传文件
            if(imgUrl.getSize() > 5 * 1024 *1024) {//如果文件大于5M，返回失败提示
                restMessage.setCode(213);
                restMessage.setMsg("error:change pic out of 5MB");
                restMessage.setData(null);
                return  restMessage;
            }
            String destWebUrl = FileUpload.returnWebUrl(imgUrl, "news");
            //更新数据库
            System.out.println("run post news:" + destWebUrl);
            News news = new News(id, title, content, sdf.parse(date), destWebUrl);//如果用户没有更新图片，执行带imgUrl的SQL
            newsService.updateOneNews(news);
        } else {
            News news = new News(Integer.valueOf(id), title, content, sdf.parse(date), null);//如果用户没有更新图片，执行不带imgUrl的SQL
            newsService.updateOneNews(news);
        }
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(null);
        return restMessage;
    }

}
