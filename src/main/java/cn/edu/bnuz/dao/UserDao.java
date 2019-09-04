package cn.edu.bnuz.dao;

import cn.edu.bnuz.entity.User;

import java.util.List;


public interface UserDao {

    List<User> queryUser();

    String queryUserByName(String userName);
}
