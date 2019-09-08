package cn.edu.bnuz.service.impl;

import cn.edu.bnuz.dao.LoginDateDao;
import cn.edu.bnuz.dao.UserDao;
import cn.edu.bnuz.entity.User;
import cn.edu.bnuz.service.UserService;
import cn.edu.bnuz.util.PageCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginDateDao loginDateDao;

    public boolean queryUserByName(String userName, String password) {
        return password.equals(userDao.queryUserByName(userName));
    }

    public boolean updatePassword(String userName, String password) {
        int effectedNum = userDao.updatePassword(userName, password);
        if(effectedNum == 1){
            return true;
        }else{
            return false;
        }
    }

    public List<Date> queryUserLoginList(long userId, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.caculateRowIndex(pageIndex, pageSize);
        List<Date> dateList = userDao.queryUserLoginList(userId, rowIndex, pageSize);
        return dateList;
    }

    public boolean addLoginDate(Date loginDate, long userId) {
        int effectedNum = loginDateDao.addLoginDate(loginDate, userId);
        if(effectedNum == 1){
            return true;
        }else{
            return false;
        }
    }
}
