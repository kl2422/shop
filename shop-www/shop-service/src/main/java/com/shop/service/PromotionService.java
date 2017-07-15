package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.PromotionDao;
import com.shop.model.Promotion;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
@Service
public class PromotionService {

    @Autowired
    private PromotionDao promotionDao;

    public List<Promotion> findPromotions(Integer categoryId, Integer limit) {
        // 基本参数验证
        AssertUtil.intIsNotEmpty(categoryId);
        if (limit == null) {
            limit = Constant.THREE;
        }
        List<Promotion> promotions = promotionDao.findPromotions(categoryId, limit);
        return promotions;
    }


}
