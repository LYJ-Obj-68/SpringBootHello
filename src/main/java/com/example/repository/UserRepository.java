package com.example.repository;

import com.example.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lxj
 *
 * 直接继承JpaRepository接口,此接口中有实现的方法
 * 注意:当传递的参数不是主键时：自己定义的方法格式也有要求
 * */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //当参数不为主键时，需要自己再此类中定义一个方法
    public List<User> findByGender(String gender);
}
