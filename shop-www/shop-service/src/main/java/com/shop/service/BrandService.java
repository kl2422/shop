package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.BrandDao;
import com.shop.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
@Service
public class BrandService {
    @Autowired
    private BrandDao brandDao;

    /**
     * 查询分类下的品牌
     * @param categoryId 分类id
     * @param limit 查询条数
     * @return
     */
    public List<Brand> findBrands(Integer categoryId, Integer limit) {

//        AssertUtil.intIsNotEmpty(categoryId);
        if (limit == null) {
            limit = Constant.FOUR;
        }
        List<Brand> brands = null;
        if (categoryId == null || categoryId < 1) {
            brands = brandDao.findBrands(limit);
        } else { // 查询分类品牌
            brands = brandDao.findCategoryBrandList(categoryId, limit);
        }
        return brands;
    }

}
