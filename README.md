# 介绍

eureka作为服务注册与发现中心



# bug踩坑

## 使用bootstrap加载eureka失败
eureka配置在application能加载，在bootstrap中配置，加载失败。

```xml
<!--从SpringBoot2.4开始，bootstrap配置文件默认是不生效的状态，需要使用以下配置-->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-bootstrap</artifactId>
    <version>3.1.6</version>
</dependency>
```

## A服务调用B服务出现502
[SpringCloudEureka+RestTemplate]
### 背景


Springboot restTemplate对象 并不具有解析eureka对象名称到ip+port的能力 需要配合@LoadBalanced注解使用
备注：eureka-client内部有spring-spring-cloud-starter-loadbalancer此依赖

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