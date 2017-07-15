package com.shop.directive;

import com.shop.model.Goods;
import com.shop.service.GoodsService;
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
public class GoodsListDirective extends BaseDirective {

    @Autowired
    private GoodsService goodsService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        Integer categoryId = getParameter(params, "categoryId", Integer.class);
        Integer tagId = getParameter(params, "tagId", Integer.class);
        Integer limit = getParameter(params, "count", Integer.class);
        List<Goods> goods = goodsService.findHotGoods(categoryId, tagId, limit);

        setVariable(env, body, "goods", goods);
    }
}
