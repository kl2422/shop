package com.shop.dao;

import com.shop.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by TW on 2017/7/14.
 */
public interface ProductCategoryDao {


    @Select("select id, name FROM xx_product_category WHERE grade = 0 ORDER BY orders LIMIT #{limit}")
    List<ProductCategory> findRootList(@Param(value = "limit") Integer limit);

    @Select("select id, name from xx_product_category WHERE parent = #{parentId} ORDER BY orders LIMIT #{limit}")
    List<ProductCategory> findChildrenList(@Param(value = "parentId") Integer parentId, @Param(value = "limit") Integer limit);
}
