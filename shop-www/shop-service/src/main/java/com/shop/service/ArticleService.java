package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.ArticleDao;
import com.shop.model.Article;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 获取分类下的文章
     * @param categoryId 分类ID
     * @param limit 查询条数
     * @return
     */
    public List<Article> findCategoryArticle(Integer categoryId, Integer limit) {

        AssertUtil.intIsNotEmpty(categoryId);
        if (limit == null) {
            limit = Constant.SIX;
        }
        List<Article> articles = articleDao.findByCategoryId(categoryId, limit);
        return articles;
    }
}
