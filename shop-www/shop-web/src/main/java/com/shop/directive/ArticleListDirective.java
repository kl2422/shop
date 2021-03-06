package com.shop.directive;

import com.shop.model.Article;
import com.shop.model.Brand;
import com.shop.service.ArticleService;
import com.shop.service.BrandService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/7/14.
 */
@Component
public class ArticleListDirective extends BaseDirective {

    @Autowired
    private ArticleService articleService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        // 解析参数
        Integer limit = getParameter(params, "count", Integer.class);
        Integer categoryId = getParameter(params, "categoryId", Integer.class);

        // 查询数据
        List<Article> articles = articleService.findCategoryArticle(categoryId, limit);

        // 输出
        setVariable(env, body, "articles", articles);

    }
}
