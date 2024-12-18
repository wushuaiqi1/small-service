package com.noorg.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "USER-SERVICE")
public interface IFeignUserService {


    @GetMapping("feign")
    String hello();
}