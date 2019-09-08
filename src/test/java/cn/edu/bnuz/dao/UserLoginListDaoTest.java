package cn.edu.bnuz.dao;

import cn.edu.bnuz.entity.UserLoginList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-dao.xml")
public class UserLoginListDaoTest {
    @Autowired
    private UserLoginListDao userLoginListDao;

    @Test
    public void test() {
        List<UserLoginList> userLoginLists = userLoginListDao.queryUserLoginList("学生甲");
        for (UserLoginList list :
                userLoginLists) {
            System.out.println("" + list.getUserId() + ":" + list.getUserName() + ":" + list.getCreateTime());
        }
    }
}
