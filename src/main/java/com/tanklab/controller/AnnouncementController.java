package com.tanklab.controller;

import com.tanklab.bean.Announcement;
import com.tanklab.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 根据页码获取多条公告信息
     * @param model
     * @param page 当前页码
     * @return 操作状态
     */
    @RequestMapping(value = "admin/announcement", method = GET)
    public String getAnnounceList(Model model,
            @RequestParam(value="page",required=true) int page) {
        int totalCount= announcementService.getAnnounceCount();  //查询总条数
        int size=10; //每页显示大小
        int maxPage=(totalCount%size==0)?totalCount/size:totalCount/size+1;//最大页数
        page=(page==0)?1:page; //当前第几页
        int start=(page-1)*size;

        List<Announcement> announceList= announcementService.getAnnounceList(start,size);
        model.addAttribute("announceList",announceList);
        /**
         * 封装翻页信息
         */
        model.addAttribute("maxPage",maxPage);
        page=maxPage==0?0:page;
        model.addAttribute("page",page);
        model.addAttribute("totalCount",totalCount);
        if(page>1)//生成并封装上一页的链接
            model.addAttribute("prePageHref","page="+(page-1));
        if(page<maxPage)//生成并封装下一页的链接
            model.addAttribute("nextPageHref","page="+(page+1));

        return "admin/announcement";
    }


}
