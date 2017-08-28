package com.demo;

import com.demo.pojo.User;
import com.demo.service.UserService;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/demo/")
public class ItemController {
    private final UserService userService;

    @Autowired
    public ItemController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "item", method = RequestMethod.GET)
    @ResponseBody
    public Object itemList() {
        Map<String, Object> map = new HashMap<>();
        map.put("list", userService.selectAllData());
        map.put("message", "查询成功");
        map.put("rcode", 0);
        return map;
    }

    @RequestMapping(value = "items")
    @ResponseBody
    public Object itemToken(@RequestParam("id") String id, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        String requestURI = request.getRequestURI();

        if (id == null || id.isEmpty()) {
            map.put("message", "id不能为空");
            map.put("recode", "100");
            return new Gson().toJson(map);
        }

        String ids = request.getParameter("id");
        User user = userService.selectIdData(Integer.parseInt(ids));
        if (user == null) {
            map.put("message", "查询成功");
            map.put("recode", "0");
            map.put("list", "");
            return new Gson().toJson(map);
        }

        map.put("message", "查询成功");
        map.put("recode", "0");
        map.put("list", user);

        return new Gson().toJson(map);
    }

    @RequestMapping(value = "name")
    @ResponseBody
    public Object queryStudentLikeUser(@RequestParam("name") String name){
        Map<String, Object> map = new HashMap<>();
        List<User> users = userService.selectLikeData(name);
        map.put("message", "查询成功");
        map.put("recode", "0");
        map.put("list", users);
        return new Gson().toJson(map);
    }

    @RequestMapping(value = "pager")
    @ResponseBody
    public Object queryPagerData(@RequestParam("pager") int pager){
        List<User> users = userService.selectPagerData(pager * 20);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "查询成功");
        map.put("recode", "0");
        map.put("list", users);
        return new Gson().toJson(map);
    }
}
