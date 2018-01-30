package com.tanklab.api;

import com.tanklab.bean.Notices;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.bean.RestMessage;
import com.tanklab.service.AnnouncementService;
import com.tanklab.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/api/v1/notices")
public class NoticesAPI {
    private NoticesService noticesService;
    @Autowired
    public NoticesAPI(NoticesService noticesService) {
        this.noticesService = noticesService;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 根据id查询单条公告信息
     * @param model
     * @param id 公告id
     * @return 操作状态
     */
    @RequestMapping(value = "/notices", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage<Notices> getNotices(Model model,
                                           @RequestParam(value="id",required=true) int id) {
        Notices noticesBean= noticesService.getNotices(id);
        RestMessage<Notices> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(noticesBean);

        return restMessage;
    }

    /**
     * 根据页码获取多条
     * @param model
     * @param size 请求的信息条数，默认日期倒序
     * @return 操作状态
     */
    @RequestMapping(value = "/topList", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage<List<Notices>> getNoticesTopList(Model model,
                                                        @RequestParam(value="size",required=true) int size) {
        List<Notices> noticesTopList=noticesService.getNoticesTopList(size);
        RestMessage<List<Notices>> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(noticesTopList);

        return restMessage;
    }

    /**
     * 根据页码获取多条公告信息
     * @param model
     * @param page 当前页码
     * @return 操作状态
     */
    @RequestMapping(value = "", method = GET, produces = "application/json")
    @ResponseBody
    public RestMessage<List<Notices>> getNoticesList(Model model,
                                                           @RequestParam(value="page",required=true) int page) {
        int totalCount=noticesService.getNoticesCount();  //查询总条数
        int size=1; //每页显示大小
        int maxPage=(totalCount%size==0)?totalCount/size:totalCount/size+1;//最大页数
        page=(page==0)?1:page; //当前第几页
        int start=(page-1)*size;
        List<Notices> noticesList=noticesService.getNoticesList(start,size);
        RestMessage<List<Notices>> restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(JDBC_STATUS.SUCCESS.toString());
        restMessage.setData(noticesList);

        return restMessage;
    }

    /**
     * 添加一条公告信息
     * @param title 公告标题
     * @param content 公告内容
     * @param date 添加日期
     * @return 操作状态
     */
    @RequestMapping(value = "", method = POST, produces = "application/json")
    @ResponseBody
    public RestMessage addNotices(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "date") Date date) {
        System.out.println("1yhhyhyh");
       Notices noticesBean=new Notices(title,content,date);
        JDBC_STATUS status= noticesService.addNotices(noticesBean);
        RestMessage restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(status.toString());
        restMessage.setData(null);

        return restMessage;
    }

    /**
     * 修改一条公告信息
     * @param id
     * @param title
     * @param content
     * @param date
     * @return 操作状态
     */
    @RequestMapping(value = "/change", method = POST, produces = "application/json")
    @ResponseBody
    public RestMessage<Notices> modifyNotices(
            @RequestParam(value = "id") int id,
            @RequestParam(value = "title") String title,
            @RequestParam(value = "content") String content,
            @RequestParam(value = "date") Date date) {
        Notices noticesBean=new Notices(id,title,content,date);
        JDBC_STATUS status= noticesService.modifyNotices(noticesBean);
        RestMessage restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(status.toString());
        restMessage.setData(null);

        return restMessage;
    }

    /**
     * 根据id删除一条公告信息
     * @param id 公告id
     * @return 操作状态
     */
    @RequestMapping(value = "", method = DELETE, produces = "application/json")
    @ResponseBody
    public RestMessage<Notices> deleteNotices(
            @RequestParam(value="id",required=true) int id) {
        JDBC_STATUS status=noticesService.deleteNotices(id);
        RestMessage restMessage = new RestMessage();
        restMessage.setCode(200);
        restMessage.setMsg(status.toString());
        restMessage.setData(null);

        return restMessage;
    }

}
