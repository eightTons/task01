package cn.edu.bnuz.web;

import cn.edu.bnuz.dao.UserLoginListDao;
import cn.edu.bnuz.entity.UserLoginList;
import cn.edu.bnuz.service.LoginDateService;
import cn.edu.bnuz.service.UserService;
import cn.edu.bnuz.util.HttpServletRequestUtil;
import cn.edu.bnuz.util.SHAUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/task01")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserLoginListDao userLoginListDao;

    @RequestMapping(value = "/logincheck", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> loginCheck(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String userName = HttpServletRequestUtil.getString(request, "userName");
        String password = HttpServletRequestUtil.getString(request, "password");
        if (userName != null && password != null) {
            password = SHAUtils.SHA1(password);
            boolean isLogin = userService.queryUserByName(userName, password);
            if(isLogin){
                request.getSession().setAttribute("userName", userName);
                modelMap.put("success", true);
                userService.addLoginDate(new Date(), 1L);
            }else{
                modelMap.put("success", false);
            }
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "用户名或者密码不能为空！");
        }
        return modelMap;
    }

    @RequestMapping(value = "/checkpassword", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> checkPassword(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String password = HttpServletRequestUtil.getString(request, "oldpassword");
        String userName = "学生甲";
        password = SHAUtils.SHA1(password);
        boolean isLogin = userService.queryUserByName(userName, password);
        if(isLogin){
            modelMap.put("success", true);
        }else{
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/updatepassword", method = RequestMethod.POST)
    private Map<String, Object> updatePassword(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        String password = HttpServletRequestUtil.getString(request, "newpassword");
        String userName = "学生甲";
        password = SHAUtils.SHA1(password);
        if(userService.updatePassword(userName, password)){
            modelMap.put("success", true);
        }else{
            modelMap.put("success", false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/listInfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> listInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        try{
            int pageSize = 4;
            List<Date> dateList = userService.queryUserLoginList(1L, 0, 1000);
            modelMap.put("dateList", dateList);
            modelMap.put("userId", 1L);
            modelMap.put("page", 1);
            modelMap.put("pageSize", pageSize);
            modelMap.put("totalPage", dateList.size()/pageSize);
            modelMap.put("userName", "学生甲");
            modelMap.put("success", true);
        }catch (Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String  login() {
        return "login";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    private String  test() {
        return "test";
    }

    @RequestMapping(value = "/listuserlogininfo", method = RequestMethod.GET)
    @ResponseBody
    private  Map<String, Object> getUserLoginList(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<UserLoginList> userLoginLists = userLoginListDao.queryUserLoginList("学生甲");
        modelMap.put("code", 200);
        modelMap.put("count", userLoginLists.size());
        modelMap.put("data", userLoginLists);
        return modelMap;
    }

}
