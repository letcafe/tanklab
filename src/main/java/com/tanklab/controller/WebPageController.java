package com.tanklab.controller;

import com.tanklab.bean.Announcement;
import com.tanklab.bean.News;
import com.tanklab.service.AnnouncementService;
import com.tanklab.service.NewsService;
import com.tanklab.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = "/")
public class WebPageController {

    private NewsService newsService;
    private NoticesService noticesService;
    private AnnouncementService announcementService;

    @Autowired
    public WebPageController(
            NewsService newsService,
            NoticesService noticesService,
            AnnouncementService announcementService) {
        this.newsService = newsService;
        this.noticesService = noticesService;
        this.announcementService = announcementService;
    }

    //欢迎页面配置跳转
    @RequestMapping(value={" ","/"})
    public String index(){
        return "redirect:/index";
    }

    //获取路径下的所有JSP文件并正常返回
    @RequestMapping(value = "/index", method = GET)
    public String showIndexJsp(Model model) {
        List<News> newsList_index1To4 = newsService.selectMany(0, 4);
        model.addAttribute("newsList", newsList_index1To4);
        model.addAttribute("news_index1", newsList_index1To4.get(0));
        model.addAttribute("news_index2To4", newsList_index1To4.subList(1, 4));
        model.addAttribute("noticesList", noticesService.getNoticesTopList(5));
        model.addAttribute("announcementList", announcementService.getAnnounceList(0, 3));
        return "/web/index";
    }

    //获取路径下的所有JSP文件并正常返回
    @RequestMapping(value = "/admin/goToLogin", method = GET)
    public String loginJsp() {
        return "/admin/login";
    }

    @RequestMapping(value = "/{webPage}", method = GET)
    public String getWebRootJsp(@PathVariable (value="webPage") String  webPage) {
        return "/web/" + webPage;
    }

    @RequestMapping(value = "/teacher/{webPage}", method = GET)
    public String getTeacherJsp(@PathVariable (value="webPage") String  webPage) {
        return "/web/teacher/" + webPage;
    }

}
