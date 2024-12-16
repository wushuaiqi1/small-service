package com.noorg.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {

    private final AtomicInteger sequence = new AtomicInteger(0);


    @GetMapping("state")
    public Boolean state() throws Exception {
        log.info("OrderController state:{}", true);
        int res = sequence.addAndGet(1);
        log.info("sequence current value:{}", res);
        return res % 2 == 0 ? Boolean.TRUE : Boolean.FALSE;
    }

}
