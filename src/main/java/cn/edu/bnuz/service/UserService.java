package cn.edu.bnuz.service;

import cn.edu.bnuz.entity.User;

public interface UserService {
    boolean queryUserByName(String userName, String pssword);
}
