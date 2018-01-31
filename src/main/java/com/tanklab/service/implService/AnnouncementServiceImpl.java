package com.tanklab.service.implService;

import com.tanklab.bean.Announcement;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.AnnouncementDao;
import com.tanklab.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * @Author yanan
 * @Desc 长期公告Service层实现类
 * @Date 2018/1/20 22:10
 */
@Repository
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    private AnnouncementDao announcementDao;
    @Autowired
    public AnnouncementServiceImpl(AnnouncementDao announcementDao) {
        this.announcementDao = announcementDao;
    }

    @Override
    public Announcement getAnnouncement(int id) {
        return announcementDao.getAnnouncement(id);
    }

    @Override
    public List<Announcement> getAnnounceAll() {
        return announcementDao.getAnnounceAll();
    }

    @Override
    public List<Announcement> getAnnounceTopList(int size) {
        return announcementDao.getAnnounceTopList(size);
    }

    @Override
    public List<Announcement> getAnnounceList(int start,int size) {
        return announcementDao.getAnnounceList(start,size);
    }

    @Override
    public int getAnnounceCount() {
        return announcementDao.getAnnounceCount();
    }

    @Override
    public JDBC_STATUS addAnnouncement(Announcement announceBean) {
        return announcementDao.addAnnouncement(announceBean);
    }

    @Override
    public JDBC_STATUS modifyAnnouncement(Announcement announceBean) {
        return announcementDao.modifyAnnouncement(announceBean);
    }

    @Override
    public JDBC_STATUS deleteAnnouncement(int id) {
        return announcementDao.deleteAnnouncement(id);
    }
}
