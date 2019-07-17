package cn.leadeon.microserviceconsumermovie.client;

import cn.leadeon.microserviceconsumermovie.config.FeignClientFallback;
import cn.leadeon.microserviceconsumermovie.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @description: UserFeignClient
 * @author: he.l
 * @create: 2019-06-11 14:25
 **/
@FeignClient(name = "microservice-provider-user",fallback = FeignClientFallback.class)
public interface UserFeignClient {

   @GetMapping(value = "/{id}")
   // @RequestLine("GET /{id}")
    User findById(@PathVariable("id") Long id);
}
