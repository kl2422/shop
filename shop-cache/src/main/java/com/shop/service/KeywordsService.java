package com.shop.service;

import com.shop.constant.RedisConstantKey;
import com.shop.util.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by TW on 2017/7/13.
 */
@Service
public class KeywordsService {

//    @Autowired
//    private RedisTemplate<String, String> redisTemplate;

    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

    /**
     * 将关键字存入redis
     * @param value 可以输入:苹果,三星
     */
    public Long setValue(String value) {
        // 参数验证
        AssertUtil.isNotEmpty(value, "请输入关键字");
        // 存入redis
        String[] values = value.split(",");
//        BoundListOperations<String, String> listOperations = redisTemplate.boundListOps(RedisConstantKey.HOT_KEYWORDS_KEY);
//        listOperations.rightPushAll(values);
        Long count = listOps.rightPushAll(RedisConstantKey.HOT_KEYWORDS_KEY, values);
        return count;
    }

    public List<String> get() {
//        BoundListOperations<String, String> listOperations = redisTemplate.boundListOps(RedisConstantKey.HOT_KEYWORDS_KEY);
//        return listOperations.range(0, -1);
        return  listOps.range(RedisConstantKey.HOT_KEYWORDS_KEY, 0, -1);
    }
}
