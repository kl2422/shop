package com.shop.directive;

import com.shop.model.Ad;
import com.shop.model.FriendLink;
import com.shop.service.AdService;
import com.shop.service.FriendLinkService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by TW on 2017/7/14.
 */
@Component
public class FriendLinkListDirective extends BaseDirective {

    @Autowired
    private FriendLinkService friendLinkService;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body)
            throws TemplateException, IOException {

        Integer limit = getParameter(params, "count", Integer.class);
        List<FriendLink> friendLinks = friendLinkService.findList(limit);

        setVariable(env, body, "friendLinks", friendLinks);
    }
}
