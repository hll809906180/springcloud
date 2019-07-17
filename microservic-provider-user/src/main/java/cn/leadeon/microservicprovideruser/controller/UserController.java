package cn.leadeon.microservicprovideruser.controller;

import cn.leadeon.microservicprovideruser.dao.UserRepository;
import cn.leadeon.microservicprovideruser.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description:
 * @author: he.l
 * @create: 2019-06-11 09:54
 **/
@RestController
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User user = this.userRepository.getOne(id);
        return user;
    }

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        LOGGER.info("request two name is "+name);
        try{
            Thread.sleep(1000000);
        }catch ( Exception e){
            LOGGER.error(" hello two error",e);
        }
        return "hello "+name+"，this is two messge";
    }
}
