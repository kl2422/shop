package com.shop.service;

import com.shop.dao.NavigationDao;
import com.shop.model.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/7/13.
 */
@Service
public class NavigationService {
    @Autowired
    private NavigationDao navigationDao;

    /**
     * 获取导航数据
     * @return
     */
    public List<Navigation> findByPosition(Integer position) {
        List<Navigation> navigations = navigationDao.find(position);
        return navigations;
    }
}
