package cn.edu.bnuz.web;

import cn.edu.bnuz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
//@RequestMapping("/task01")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/fuck", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> user(@RequestParam(value = "name") String userName, @RequestParam(value = "password") String password) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean isLogin = userService.queryUserByName(userName, password);
        if (isLogin) {
            modelMap.put("success", true);
            return modelMap;
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "密码错误");
            return modelMap;
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    private String userLogin() {
        return "login";
    }
}
