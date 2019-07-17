package cn.leadeon.microservicprovideruser.dao;

import cn.leadeon.microservicprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: he.l
 * @create: 2019-06-11 09:51
 **/
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
