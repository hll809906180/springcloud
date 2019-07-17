package cn.leadeon.microserviceconsumermovie.controller;

import cn.leadeon.microserviceconsumermovie.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @description:
 * @author: he.l
 * @create: 2019-06-11 14:25
 **/
@RestController
public class MovieController {
    /**
     *     在微服务都是以HTTP接口的形式暴露自身服务的，因此在调用远程服务时就必须使用HTTP客户端。
     * 我们可以使用JDK原生的URLConnection、Apache的Http Client、Netty的异步HTTP Client,
     * Spring的RestTemplate。但是，用起来最方便、最优雅的还是要属Feign了。这里介绍的是RestTemplate。
     */
    private static final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User UserFindById(@PathVariable Long id){
        return  this.restTemplate.getForObject("http://microservice-provider-user/"+id,User.class);
    }
    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        MovieController.logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
