package com.noorg.feign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class IFeignUserServiceTest {
    @Resource
    private IFeignUserService feignUserService;


    @Test
    public void TestHello(){
        String hello = feignUserService.hello();
        System.out.println(hello);
    }
}
