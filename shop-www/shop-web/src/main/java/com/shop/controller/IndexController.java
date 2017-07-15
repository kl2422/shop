package com.shop.controller;

import com.shop.base.BaseController;
import com.shop.base.ResultInfo;
import com.shop.constant.Constant;
import com.shop.constant.UrlConstant;
import com.shop.model.Navigation;
import com.shop.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.jws.WebParam;
import java.util.List;

/**
 * Created by TW on 2017/7/13.
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private NavigationService navigationService;

    @Value(value = "${app.cache.service-url}")
    private String cacheServiceUrl;

    @RequestMapping("index")
    public String index(Model model) {
        return "index";
    }

}
