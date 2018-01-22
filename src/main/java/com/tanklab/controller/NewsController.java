package com.tanklab.controller;

import com.tanklab.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping("/")
public class NewsController {

    private NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @RequestMapping(value = "/newsList", method = GET)
    public String getAllNews(Model model) {
        model.addAttribute("newsList", newsService.selectNewsList());
        return "news";
    }

    @RequestMapping(value = "/{staticJsp}", method = GET)
    public String getAllNews(@PathVariable(value = "staticJsp") String staticJsp) {
        return staticJsp;
    }

}
