package cn.leadeon.microserviceconsumermovie.client;

import cn.leadeon.microserviceconsumermovie.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @description: UserFeignClient
 * @author: he.l
 * @create: 2019-06-11 14:25
 **/
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
