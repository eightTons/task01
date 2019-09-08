package cn.edu.bnuz.dao;

import cn.edu.bnuz.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface UserDao {

    List<Date> queryUserLoginList(
            @Param("userId") long userId,
            @Param("rowIndex") int rowIndex,
            @Param("pageSize") int pageSize);

    String queryUserByName(String userName);

    int updatePassword(@Param("userName") String userName, @Param("password") String password);

    long queryUserId(String userName);

}
