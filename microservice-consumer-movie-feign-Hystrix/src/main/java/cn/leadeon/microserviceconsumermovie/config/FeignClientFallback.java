package cn.leadeon.microserviceconsumermovie.config;

import cn.leadeon.microserviceconsumermovie.client.UserFeignClient;
import cn.leadeon.microserviceconsumermovie.entity.User;
import org.springframework.stereotype.Component;

/**
 * @description: 配置hystrix 回退类
 * @author: he.l
 * @create: 2019-07-08 17:00
 */

@Component
public class FeignClientFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setName("默认名字");
        return user;
    }
}
