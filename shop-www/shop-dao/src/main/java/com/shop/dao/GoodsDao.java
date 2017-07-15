package com.shop.dao;

import com.shop.model.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
public interface GoodsDao {

    @Select("SELECT g.id, g.NAME, g.caption, g.image, g.price FROM xx_goods g LEFT JOIN " +
            " xx_product_category p on g.product_category = p.id LEFT JOIN xx_goods_tag t on g.id=t.goods " +
            " where p.tree_path LIKE ',${categoryId},%' AND t.tags = #{tagId} and g.is_marketable=1 order by g.id LIMIT #{limit}")
    List<Goods> findHotGoods(@Param(value = "categoryId") Integer categoryId,
                             @Param(value = "tagId")Integer tagId, @Param(value = "limit")Integer limit);
}
