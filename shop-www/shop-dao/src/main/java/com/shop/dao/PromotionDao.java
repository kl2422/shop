package com.shop.dao;

import com.shop.model.Promotion;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
public interface PromotionDao {

    @Select("SELECT id, image, name FROM xx_promotion t1 LEFT JOIN xx_product_category_promotion t2 " +
            " on t1.id = t2.promotions WHERE t2.product_categories = #{categoryId} " +
            " order BY t1.orders LIMIT #{limit}")
    List<Promotion> findPromotions(@Param(value = "categoryId") Integer categoryId, @Param(value = "limit") Integer limit);
}
