package com.shop.service;

import com.shop.dao.ProductCategoryDao;
import com.shop.model.ProductCategory;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * 查询根级商品分类
     * @param limit
     * @return
     */
    public List<ProductCategory> findRootList(Integer limit) {
        if(limit == null || limit < 1) {
            limit = 6;
        }
        List<ProductCategory> productCategories = productCategoryDao.findRootList(limit);
        return productCategories;

    }

    /**
     * 查询子级分类
     * @param parentId
     * @param limit
     * @return
     */
    public List<ProductCategory> findChildrenList(Integer parentId, Integer limit) {
        AssertUtil.intIsNotEmpty(parentId, "请选择一个父级分类");
        if(limit == null || limit < 1) {
            limit = 3;
        }

        List<ProductCategory> productCategories = productCategoryDao.findChildrenList(parentId, limit);
        return productCategories;
    }
}
