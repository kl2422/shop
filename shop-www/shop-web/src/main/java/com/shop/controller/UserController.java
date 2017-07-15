package com.shop.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shop.model.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/7/12.
 */
@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping("find/{id}")
    @ResponseBody
    public User finds(@PathVariable Integer id) {

        return userService.find(id);
    }

    @RequestMapping("list.json")
    @ResponseBody
    public Map<String, Object> selectForPage(Integer page, Integer pageSize, String sort) {
        PageList<User> users = userService.selectForPage(page, pageSize, sort);
        Map<String, Object> result = new HashMap<>();
        result.put("users", users);
        result.put("paginator", users.getPaginator());
        return result;
    }

    @RequestMapping("list")
    public String selectForPage(Integer page, Integer pageSize, String sort, Model model) {
        PageList<User> users = userService.selectForPage(page, pageSize, sort);
        model.addAttribute("users", users);
        model.addAttribute("paginator", users.getPaginator());
        return "user_list";
    }

}
