package com.shop.directive;

import com.shop.model.AdPosition;
import com.shop.service.AdPositionService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TW on 2017/7/14.
 */
@Component
public class AdPositionDirective extends BaseDirective {

    @Autowired
    private AdPositionService adPositionService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        Integer positionId = getParameter(params, "positionId", Integer.class);

        AdPosition adPosition = adPositionService.findById(positionId);

        // 模板内容 数据 + 模板 = 输出
        String content = adPosition.getTemplate();
        StringReader reader = new StringReader(content);
        Configuration cfg = freeMarkerConfigurer.getConfiguration(); // 从spring的Freemarker视图配置中获取Freemarker的配置
        Template template = new Template("adTemplate", reader, cfg);
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("adPosition", adPosition);
        template.process(dataModel, env.getOut());
    }
}
