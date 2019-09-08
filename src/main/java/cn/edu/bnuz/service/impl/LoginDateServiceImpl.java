package cn.edu.bnuz.service.impl;

import cn.edu.bnuz.dao.LoginDateDao;
import cn.edu.bnuz.entity.LoginDate;
import cn.edu.bnuz.service.LoginDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoginDateServiceImpl implements LoginDateService {
    @Autowired
    private LoginDateDao loginDateDao;


    public List<LoginDate> listLoginDate() {
        return loginDateDao.listLoginDate();
    }

    public int listLoginDateAccount() {
        return loginDateDao.listLoginDateAccount();
    }
}
