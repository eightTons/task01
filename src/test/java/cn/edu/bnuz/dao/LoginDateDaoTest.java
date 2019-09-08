package cn.edu.bnuz.dao;

import cn.edu.bnuz.entity.LoginDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-dao.xml")
public class LoginDateDaoTest {
    @Autowired
    private LoginDateDao loginDateDao;

    @Test
    public void addLoginDate() {
        int effectedNum = loginDateDao.addLoginDate(new Date(), 1L);
        assertEquals(1, effectedNum);
    }

    @Test
    public void listLoginDate(){
        List<LoginDate> loginDateList = loginDateDao.listLoginDate();
        for (LoginDate loginDate: loginDateList){
            System.out.println(""+loginDate.getLoginDateId()+" : " + loginDate.getCreateTime() + " : " + loginDate.getUserId());
        }
        assertEquals(8, loginDateList.size());
    }

    @Test
    public void testListLoginDateAccount(){
        int count = loginDateDao.listLoginDateAccount();
        assertEquals(8, count);
    }


}