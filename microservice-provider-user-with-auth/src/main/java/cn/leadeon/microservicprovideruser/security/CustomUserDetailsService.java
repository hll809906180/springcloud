package cn.leadeon.microservicprovideruser.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: he.l
 * @create: 2019-07-02 16:32
 **/
@Component
public class CustomUserDetailsService implements UserDetailsService {
    /**
     * 模拟两个账户
     * ① 账号是user，密码是password1，角色是user-role
     * ② 账号时候admin，密码是password1，角色是admin-role
     * @param username
     *                  用户名
     * @return
     *
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new SecurityUser("user", "password1", "user-role");
        } else if ("admin".equals(username)) {
            return new SecurityUser("admin", "password2", "admin-role");
        } else {
            return null;
        }
    }
}
