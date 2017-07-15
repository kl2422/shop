package com.shop.service;

/**
 * Created by TW on 2017/7/12.
 */

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shop.dao.UserDao;
import com.shop.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User find(Integer id) {
        if (id == null) {
            return null;
        }

        return userDao.findById(id);
    }

    public PageList<User> selectForPage(Integer page, Integer pageSize, String sort) {
        // 参数判断
        if (page == null || page == 0) {
            page = 1;
        }

        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }

        // 构建一个PageBounds
        PageBounds pageBounds = new PageBounds(page, pageSize);
        if (StringUtils.isNotBlank(sort)) { // 构建一个排序字段
            pageBounds.setOrders(Order.formString(sort));
        }
        // 查询 返回
        PageList<User> users = userDao.selectForPage(pageBounds);
        return users;
    }
}
