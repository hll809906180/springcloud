package cn.leadeon.microservicprovideruser.controller;

import cn.leadeon.microservicprovideruser.dao.UserRepository;
import cn.leadeon.microservicprovideruser.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

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
    public User findById(@PathVariable Long id) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails user = (UserDetails) principal;
            Collection<? extends GrantedAuthority> collections = user.getAuthorities();
            for (GrantedAuthority ga: collections) {
                // 打印当前登录用户的信息
                UserController.LOGGER.info("当前用户是{}, 角色是{}", user.getUsername(), ga.getAuthority());
            }
        } else {
            UserController.LOGGER.warn("ε=(´ο｀*)))唉，出现问题了");
        }
        User findOne = userRepository.findById(id).get();
        return findOne;
    }

}
