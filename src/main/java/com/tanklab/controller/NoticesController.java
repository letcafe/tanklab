package com.tanklab.controller;

import com.tanklab.bean.Notices;
import com.tanklab.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
@RequestMapping("/")
public class NoticesController {

    private NoticesService noticesService;
    @Autowired
    public NoticesController(NoticesService noticesService) {
        this.noticesService = noticesService;
    }

    /**
     * 根据id查询单条公告信息
     * @param model
     * @param id 公告id
     * @return 操作状态
     */
    @RequestMapping(value = "/getNotices", method = GET)
    public String getNotices(Model model,
                                  @RequestParam(value="id",required=true) Integer id) {
        Notices noticesBean= noticesService.getNotices(id);
        model.addAttribute("noticesBean",noticesBean);
        return "getNotices";
    }

    /**
     * 根据页码获取多条
     * @param model
     * @param size 请求的信息条数，默认日期倒序
     * @return 操作状态
     */
    @RequestMapping(value = "/getNoticesTopList", method = GET)
    public String getNoticesTopList(Model model,
                                     @RequestParam(value="size",required=true) Integer size) {
        List<Notices> noticesTopList= noticesService.getNoticesTopList(size);
        model.addAttribute("noticesTopList",noticesTopList);

        return "noticesTopList";
    }

    /**
     * 根据页码获取多条公告信息
     * @param model
     * @param page 当前页码
     * @return 操作状态
     */

    /**封装一个noticesList对象返回到视图jsp中**/
    @RequestMapping(value = "admin/notices", method = GET)
    public String getAllNotices(Model model, @RequestParam(value = "page") Integer page) {
        int totalCount = noticesService.getNoticesCount();
        int pageSize = 10;
        int maxPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        page = (page == 0) ? 1 : page;
        int start = (page - 1) * pageSize;
        List<Notices> noticesList = noticesService.getNoticesList(start,pageSize);


        model.addAttribute("noticesList", noticesList);
        page = (maxPage == 0) ? 0 : page;
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        if(page > 1) {
            model.addAttribute("prePageIndex", page - 1);
        }
        if(page < maxPage) {
            model.addAttribute("nextPageIndex", page + 1);
        }
        return "/admin/notices";
    }

    /**前台展示部分，进行jsp映射**/
    @RequestMapping(value = "/noticesList")
    public String getPagedNews(Model model, @RequestParam(value = "page") Integer page) {
        int totalCount = noticesService.getNoticesCount();
        int pageSize = 10;
        int maxPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : (totalCount / pageSize + 1);
        page = (page == 0) ? 1 : page;
        int start = (page - 1) * pageSize;
        List<Notices> noticesList = noticesService.getNoticesList(start,pageSize);


        model.addAttribute("pagedNotices", noticesList);
        page = (maxPage == 0) ? 0 : page;
        model.addAttribute("page", page);
        model.addAttribute("maxPage", maxPage);
        if(page > 1) {
            model.addAttribute("prePageIndex", page - 1);
        }
        if(page < maxPage) {
            model.addAttribute("nextPageIndex", page + 1);
        }
        return "/web/noticesList";
    }

    @RequestMapping(value = "/detailNotices")
    public String detailNewsJsp(Model model, @RequestParam(value = "id") Integer id) {
        Notices notices = noticesService.getNotices(id);
        model.addAttribute("detailNotices", notices);
        return "/web/detailNotices";
    }


}