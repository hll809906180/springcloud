package cn.leadeon.microserviceconsumermovie.client;

import cn.leadeon.microserviceconsumermovie.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description: UserFeignClient
 * @author: he.l
 * @create: 2019-06-11 14:25
 **/
public interface UserFeignClient {

    @GetMapping(value = "/{id}")
    User findById(@PathVariable("id") Long id);
}
