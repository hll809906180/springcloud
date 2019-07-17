package cn.leadeon.microserviceconsumermovie.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 定义ribbon 负载规则
 * @author: he.l
 * @create: 2019-06-26 16:59
 **/
@Configuration
public class RibbonConfigration {
    @Bean
    public IRule ribbonRule(){
        return  new RandomRule();
    }
}
