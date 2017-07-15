package com.shop.directive;

import com.shop.model.ProductCategory;
import com.shop.service.ProductCategoryService;
import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.Configuration;
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
public class ProductCategoryRootListDirective extends BaseDirective {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        // 解析参数
        Integer limit = getParameter(params, "count", Integer.class);

        // 查询数据
        List<ProductCategory> productCategories = productCategoryService.findRootList(limit);

        // 输出
        setVariable(env, body, "rootProductCategories", productCategories);

    }
}
