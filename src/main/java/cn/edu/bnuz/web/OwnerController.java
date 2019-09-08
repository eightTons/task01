package cn.edu.bnuz.web;

import cn.edu.bnuz.entity.LoginDate;
import cn.edu.bnuz.service.LoginDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OwnerController {
    @Autowired
    private LoginDateService loginDateService;

    @RequestMapping(value = "/owner", method = RequestMethod.GET)
    private String owner() {
        return "owner";
    }

    @RequestMapping(value = "/listlogindate", method = RequestMethod.GET)
    @ResponseBody
    private  Map<String, Object> listLoginDate(HttpServletRequest request){
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<LoginDate> dateList = loginDateService.listLoginDate();
        modelMap.put("loginDateList", dateList);
        return modelMap;
    }
}
