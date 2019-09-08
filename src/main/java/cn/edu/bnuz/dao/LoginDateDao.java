package cn.edu.bnuz.dao;

import cn.edu.bnuz.entity.LoginDate;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface LoginDateDao {
    int addLoginDate(@Param("loginDate") Date loginDate,
                     @Param("userId") long userId);

    List<LoginDate> listLoginDate();

    int listLoginDateAccount();


}
