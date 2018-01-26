package com.tanklab.controller;

import com.tanklab.bean.Notices;
import com.tanklab.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "/getNoticesList", method = GET)
    public String getNoticesList(Model model,
                                 @RequestParam(value="page",required=true) Integer page) {
        int totalCount= noticesService.getNoticesCount();  //查询总条数
        int size=10; //每页显示大小
        int maxPage=(totalCount%size==0)?totalCount/size:totalCount/size+1;//最大页数
        page=(page==0)?1:page; //当前第几页
        int start=(page-1)*size;

        List<Notices> noticesList= noticesService.getNoticesList(start,size);
        model.addAttribute("noticesList",noticesList);
        /**
         * 封装翻页信息
         */
        model.addAttribute("maxPage",maxPage);
        page=maxPage==0?0:page;
        model.addAttribute("page",page);
        model.addAttribute("totalCount",totalCount);
        if(page>1)//生成并封装上一页的链接
            model.addAttribute("prePageHref","getAnnounceList.do?&page="+(page-1));
        if(page<maxPage)//生成并封装下一页的链接
            model.addAttribute("nextPageHref","getAnnounceList.do?&page="+(page+1));

        return "noticesList";
    }

}
