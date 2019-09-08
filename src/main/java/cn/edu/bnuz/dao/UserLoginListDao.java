package cn.edu.bnuz.dao;

import cn.edu.bnuz.entity.UserLoginList;

import java.util.List;

public interface UserLoginListDao {
    List<UserLoginList> queryUserLoginList(String userName);
}
