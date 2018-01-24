package com.tanklab.dao;

import com.tanklab.bean.Notices;
import com.tanklab.bean.JDBC_STATUS;

import java.util.List;

public interface NoticesDao {
    public Notices getNotices(int id); //获取指定id的公告信息
    public List<Notices> getNoticesTopList(int size); //获取指定size条数的公告信息，用于首页展示topList
    public List<Notices> getNoticesList(int start,int size); //获取翻页公告信息，start,size用于sql查询"limit start,size;"
    public int getNoticesCount(); //获取公告信息总数，用于翻页计算sql截取位置
    public JDBC_STATUS addNotices(Notices noticesBean); //添加一条公告信息
    public JDBC_STATUS modifyNotices(Notices noticesBean); //修改一条公告信息
    public JDBC_STATUS deleteNotices(int id); //删除指定id的公告信息
}
