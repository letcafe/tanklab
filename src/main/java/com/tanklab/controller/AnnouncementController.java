package com.tanklab.controller;

import com.tanklab.bean.Announcement;
import com.tanklab.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * @Author yanan
 * @Desc 长期公告控制器类
 * @Date 2018/1/20 21:43
 */
@Controller
@RequestMapping("/")
public class AnnouncementController {

    private AnnouncementService announcementService;
    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    /**
     * 根据id查询单条公告信息
     * @param model
     * @param id 公告id
     * @return 操作状态
     */
    @RequestMapping(value = "/getAnnouncement", method = GET)
    public String getAnnouncement(Model model,
            @RequestParam(value="id",required=true) int id) {
        Announcement announceBean= announcementService.getAnnouncement(id);
        model.addAttribute("announceBean",announceBean);
        return "getAnnouncement";
    }

    /**
     * 根据页码获取多条
     * @param model
     * @param size 请求的信息条数，默认日期倒序
     * @return 操作状态
     */
    @RequestMapping(value = "/getAnnounceTopList", method = GET)
    public String getAnnounceTopList(Model model,
            @RequestParam(value="size",required=true) int size) {
        List<Announcement> announceTopList= announcementService.getAnnounceTopList(size);
        model.addAttribute("announceTopList",announceTopList);

        return "announceTopList";
    }

    @RequestMapping(value = "/admin/announcement", method = GET)
    public String getAdminList(HttpSession session, Model model, @RequestParam(value = "page", required = false, defaultValue = "1") Integer page) {
        int totalCount = announcementService.getAnnounceCount();
        int pageSize = 10;
        int maxPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        page = (page == 0) ? 1 : page;
        int start = (page - 1) * pageSize;
        List<Announcement> announcementList = announcementService.getAnnounceList(start, pageSize);


        model.addAttribute("announcementList", announcementList);
        page = (maxPage == 0) ? 0 : page;
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        if (page > 1) {
            model.addAttribute("prePageIndex", page - 1);
        }
        if (page < maxPage) {
            model.addAttribute("nextPageIndex", page + 1);
        }
        return "/admin/announcement";
    }

    /**前台展示部分，进行jsp映射**/
    @RequestMapping(value = "/announcementList")
    public String getPagedNews(Model model, @RequestParam(value = "page") Integer page) {
        int totalCount = announcementService.getAnnounceCount();
        int pageSize = 10;
        int maxPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        page = (page == 0) ? 1 : page;
        int start = (page - 1) * pageSize;
        List<Announcement> announcementList = announcementService.getAnnounceList(start,pageSize);


        model.addAttribute("pagedAnnouncement", announcementList);
        page = (maxPage == 0) ? 0 : page;
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        if(page > 1) {
            model.addAttribute("prePageIndex", page - 1);
        }
        if(page < maxPage) {
            model.addAttribute("nextPageIndex", page + 1);
        }
        return "/web/announcementList";
    }

    @RequestMapping(value = "/detailAnnouncement")
    public String detailAnnouncementJsp(Model model, @RequestParam(value = "id") Integer id) {
        Announcement announcement = announcementService.getAnnouncement(id);
        model.addAttribute("detailAnnouncement", announcement);
        return "/web/detailAnnouncement";
    }


}
