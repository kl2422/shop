package com.shop.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shop.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TW on 2017/7/12.
 */
public interface UserDao {

    @Select("select id, userName, password, gender from t_user where id = #{id}")
    User findById(@Param(value = "id") Integer id);

    @Select("select id, userName, password, gender from t_user")
    PageList<User> selectForPage(PageBounds pageBounds);
}
