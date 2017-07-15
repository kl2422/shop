package com.shop.directive;

import com.shop.model.Ad;
import com.shop.model.AdPosition;
import com.shop.service.AdPositionService;
import com.shop.service.AdService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/7/14.
 */
@Component
public class AdDirective extends BaseDirective {

    @Autowired
    private AdService adService;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        Integer positionId = getParameter(params, "positionId", Integer.class);

        List<Ad> ads = adService.findPositionAds(positionId);

        setVariable(env, body, "ads", ads);
    }
}
