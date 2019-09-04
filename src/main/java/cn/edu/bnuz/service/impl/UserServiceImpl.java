package cn.edu.bnuz.service.impl;

import cn.edu.bnuz.dao.UserDao;
import cn.edu.bnuz.entity.User;
import cn.edu.bnuz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public boolean queryUserByName(String userName, String password) {
        return password.equals(userDao.queryUserByName(userName));
    }
}
