package cn.edu.bnuz.service;

import cn.edu.bnuz.entity.LoginDate;

import java.util.Date;
import java.util.List;

public interface LoginDateService {
    List<LoginDate> listLoginDate();

    int listLoginDateAccount();
}
