package cn.leadeon.microserviceconsumermovie.config;

import cn.leadeon.microserviceconsumermovie.annotation.ExcludeComponent;
import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 自定义Feign
 * @author: he.l
 * @create: 2019-06-27 17:35
 **/
@ExcludeComponent
@Configuration
public class FeignConfigration {
    /**
     * 将契约改为feign原生的契约 可以使用feign 自带的注解
     * @return
     */
    @Bean
    public Contract feignContract(){
        return new Contract.Default();
    }
}
