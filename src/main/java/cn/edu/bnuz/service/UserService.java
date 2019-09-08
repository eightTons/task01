package cn.edu.bnuz.service;

import cn.edu.bnuz.entity.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    boolean queryUserByName(String userName, String pssword);

    boolean updatePassword(String userName, String password);

    List<Date> queryUserLoginList(long userId, int pageIndex, int pageSize);

    boolean addLoginDate(Date loginDate, long userId);
}
