/*
package cn.leadeon.microserviceconsumermovie.config;

import cn.leadeon.microserviceconsumermovie.client.UserFeignClient;
import cn.leadeon.microserviceconsumermovie.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

*/
/**
 * @description: FallbackFactory 检查回退原因
 * @author: he.l
 * @create: 2019-07-08 17:06
 **//*

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                FeignClientFallbackFactory.LOGGER.info("fallback reason:",cause);
                User user = new User();
                user.setId(-1L);
                user.setName("默认名字");
                return user;
            }
        };
    }
}
*/
