package com.shop.directive;

import com.alibaba.fastjson.JSON;
import com.shop.base.ResultInfo;
import com.shop.constant.Constant;
import com.shop.constant.UrlConstant;
import com.shop.model.Navigation;
import com.shop.service.NavigationService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/7/13.
 */
@Component
public class HotSearchKeywordsDirective extends BaseDirective {

    @Value("${JDBC.url}")
    private String jdbcUrl;

    @Value("${app.cache.service-url}")
    private String cacheDomain;


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        // 获取热门关键字
        RestTemplate restTemplate = new RestTemplate();
        String url = cacheDomain + UrlConstant.HOT_KEYWORDS_URL;
        ResponseEntity<ResultInfo> entity =
                restTemplate.getForEntity(url, ResultInfo.class);

        List<String> hotKeywords = new ArrayList<>();
        if (entity.getStatusCode() == HttpStatus.OK) {
            // 请求成功
            ResultInfo resultInfo = entity.getBody();
            if (resultInfo.getResultCode() == Constant.SUCCESS_CODE) {
                hotKeywords = (List<String>)resultInfo.getResult();
            }
        }

       setVariable(env, body, "keywords", hotKeywords);
    }
}
