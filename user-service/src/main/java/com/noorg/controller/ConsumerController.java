package com.noorg.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("consumer")
public class ConsumerController {


    @Resource
    private RestTemplate restTemplate;


    @GetMapping
    public String fetch() {
        Boolean forEntity = restTemplate.getForObject("http://ORDER-SERVICE/order/state", Boolean.class);
        log.info("ConsumerController res:{}", JSON.toJSONString(forEntity));
        return "服务消费成功!";
    }

    @GetMapping("instance")
    public String getInstance(){
        String forObject = restTemplate.getForObject("http://localhost:8761/eureka/apps", String.class);
        return forObject;
    }
}
