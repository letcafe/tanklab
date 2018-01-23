package com.tanklab.dao;

import com.tanklab.bean.Announcement;
import com.tanklab.bean.JDBC_STATUS;

import java.util.List;

/**
 * @Author yanan
 * @Desc 长期公告dao层接口
 * @Date 2018/1/20 22:09
 */
public interface AnnouncementDao {
    public Announcement getAnnouncement(int id); //获取指定id的公告信息
    public List<Announcement> getAnnounceTopList(int size); //获取指定size条数的公告信息，用于首页展示topList
    public List<Announcement> getAnnounceList(int start,int size); //获取翻页公告信息，start,size用于sql查询"limit start,size;"
    public int getAnnounceCount(); //获取公告信息总数，用于翻页计算sql截取位置
    public JDBC_STATUS addAnnouncement(Announcement announceBean); //添加一条公告信息
    public JDBC_STATUS modifyAnnouncement(Announcement announceBean); //修改一条公告信息
    public JDBC_STATUS deleteAnnouncement(int id); //删除指定id的公告信息
}
