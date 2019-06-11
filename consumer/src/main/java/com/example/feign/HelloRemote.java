package com.example.feign;

import com.example.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by sunming on 2019/6/11.
 */
//指定fallback类，在服务熔断的时候返回fallback类中的内容
@FeignClient(name = "spring-cloud-producer",fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    /**
     * 此类中的方法和远程服务中contoller中的方法名和参数需保持一致。
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);
}
