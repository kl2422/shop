package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.ArticleCategoryDao;
import com.shop.model.ArticleCategory;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
@Service
public class ArticleCategoryService {

    @Autowired
    private ArticleCategoryDao articleCategoryDao;


    public List<ArticleCategory> findRootList(Integer limit) {
        if (limit == null) {
            limit = Constant.TWO;
        }
        List<ArticleCategory> articleCategories = articleCategoryDao.findRootList(limit);
        return articleCategories;
    }
}
