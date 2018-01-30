package com.tanklab.controller;

import com.tanklab.bean.News;
import com.tanklab.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/", method = GET)
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/admin/news")
    public String getAllNews(HttpSession sesion, Model model) {
        model.addAttribute("newsList", newsService.selectNewsList());
        return "admin/news";
    }

    @RequestMapping(value = "/uploadForm")
    public String uploadForm(Model model) {
        return "web/uploadForm";
    }

    @RequestMapping(value = "/news")
    public String getDetailedNews(
            Model model,
            @RequestParam(value = "id") int id) {
        model.addAttribute("detailedNews", newsService.selectDetailedNews(id));
        return "detailedNews";
    }

    @RequestMapping(value = "/newsList")
    public String getPagedNews(Model model, @RequestParam(value = "page") Integer page) {
        int totalCount = newsService.getTableCount();
        int pageSize = 10;
        int maxPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        page = (page == 0) ? 1 : page;
        int startIndex = (page - 1) * pageSize;
        List<News> newsList = newsService.selectMany(startIndex, pageSize);

        model.addAttribute("pagedNews", newsList);
        page = (maxPage == 0) ? 0 : page;
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        if(page > 1) {
            model.addAttribute("prePageIndex", page - 1);
        }
        if(page < maxPage) {
            model.addAttribute("nextPageIndex", page + 1);
        }
        return "/web/newsList";
    }

    @RequestMapping(value = "/detailNews")
    public String detailNewsJsp(Model model, @RequestParam(value = "id") Integer id) {
        News news = newsService.selectDetailedNews(id);
        model.addAttribute("detailNews", news);
        return "/web/detailNews";
    }


}
