package com.tanklab.service.implService;

import com.tanklab.bean.Announcement;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.AnnounceDao;
import com.tanklab.service.AnnounceService;
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
public class AnnounceServiceImpl implements AnnounceService {

    private AnnounceDao announceDao;
    @Autowired
    public AnnounceServiceImpl(AnnounceDao announceDao) {
        this.announceDao = announceDao;
    }

    @Override
    public Announcement getAnnouncement(int id) {
        return announceDao.getAnnouncement(id);
    }

    @Override
    public List<Announcement> getAnnounceTopList(int size) {
        return announceDao.getAnnounceTopList(size);
    }

    @Override
    public List<Announcement> getAnnounceList(int start,int size) {
        return announceDao.getAnnounceList(start,size);
    }

    @Override
    public int getAnnounceCount() {
        return announceDao.getAnnounceCount();
    }

    @Override
    public JDBC_STATUS addAnnouncement(Announcement announceBean) {
        return announceDao.addAnnouncement(announceBean);
    }

    @Override
    public JDBC_STATUS modifyAnnouncement(Announcement announceBean) {
        return announceDao.modifyAnnouncement(announceBean);
    }

    @Override
    public JDBC_STATUS deleteAnnouncement(int id) {
        return announceDao.deleteAnnouncement(id);
    }
}
