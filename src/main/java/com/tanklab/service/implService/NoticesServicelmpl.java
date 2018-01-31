package com.tanklab.service.implService;

import com.tanklab.bean.Notices;
import com.tanklab.bean.JDBC_STATUS;
import com.tanklab.dao.NoticesDao;
import com.tanklab.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class NoticesServicelmpl implements NoticesService {
    private NoticesDao noticesDao;
    @Autowired
    public NoticesServicelmpl(NoticesDao noticesDao) { this.noticesDao = noticesDao;}

    @Override
    public List<Notices> getAllNotices() { return noticesDao.getAllNotices(); }

    @Override
    public Notices getNotices(int id) { return noticesDao.getNotices(id); }

    @Override
    public List<Notices> getNoticesTopList(int size) {
        return noticesDao.getNoticesTopList(size);
    }

    @Override
    public List<Notices> getNoticesList(int start,int size) {
        return noticesDao.getNoticesList(start,size);
    }

    @Override
    public int getNoticesCount() {
        return noticesDao.getNoticesCount();
    }

    @Override
    public JDBC_STATUS addNotices(Notices noticesBean) {
        return noticesDao.addNotices(noticesBean);
    }

    @Override
    public JDBC_STATUS modifyNotices(Notices noticesBean) {
        return noticesDao.modifyNotices(noticesBean);
    }

    @Override
    public JDBC_STATUS deleteNotices(int id) {
        return noticesDao.deleteNotices(id);
    }
}
