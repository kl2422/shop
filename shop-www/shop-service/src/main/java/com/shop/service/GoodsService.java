package com.shop.service;

import com.shop.constant.Constant;
import com.shop.dao.GoodsDao;
import com.shop.model.Goods;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    /**
     * 获取热门商品
     * @param categoryId
     * @param tagId
     * @param limit
     * @return
     */
    public List<Goods> findHotGoods(Integer categoryId, Integer tagId, Integer limit) {
        AssertUtil.intIsNotEmpty(categoryId);
        AssertUtil.intIsNotEmpty(tagId);
        if (limit == null) {
            limit = Constant.TEN;
        }
        List<Goods> goods = goodsDao.findHotGoods(categoryId, tagId, limit);
        return goods;
    }
}
