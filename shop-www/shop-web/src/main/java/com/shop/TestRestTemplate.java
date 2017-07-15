package com.shop;

import com.shop.base.ResultInfo;
import com.shop.constant.Constant;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sun.applet.Main;

import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by TW on 2017/7/13.
 */
public class TestRestTemplate {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultInfo> entity =
                restTemplate.getForEntity("http://localhost:8090/keywords/get", ResultInfo.class);
        if (entity.getStatusCode() == HttpStatus.OK) {
            // 请求成功
            ResultInfo resultInfo = entity.getBody();
            if (resultInfo.getResultCode() != Constant.SUCCESS_CODE) {
                return;
            }
            List<String> hotKeywords = (List<String>)resultInfo.getResult();
            System.out.println(hotKeywords.size());
        }


        String result = restTemplate.getForObject(
                "http://example.com/hotels/{hotel}/bookings/{booking}", String.class,"42", "21");
        System.out.println(result);

    }
}
