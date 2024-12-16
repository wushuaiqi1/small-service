# 介绍
application.yml成功加载eureka服务，但是使用bootstrap却加载失败。


eureka作为注册中心


# bug踩坑

## A服务调用B服务出现502
[SpringCloudEureka+RestTemplate]
### 背景


Springboot restTemplate对象 并不具有解析eureka对象名称到ip+port的能力 需要配合@LoadBalanced注解使用
需要引入依赖
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-loadbalancer</artifactId>
    <version>3.1.7</version>
</dependency>
```

```java
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced // 使用负载均衡注解，可以解析到指定的服务ip
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}


```