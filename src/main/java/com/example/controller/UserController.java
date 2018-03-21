package com.example.controller;

import com.example.bean.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lxj
 *
 * 注意:项目的目录结构,后面建的文件夹需要与DemoApplication同级,否则报错
 * */
@RestController   //将类注册到spring
public class UserController {
    @Autowired  //加载类
    private UserRepository userRepository;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String HelloWorld () {
        return "Hello World!";
    }

    //查询user列表
    @GetMapping(value = "/userlist")  //注册请求方式：方式+Mapping
    public List<User> listUser(){
        List<User> listUser = new ArrayList<>();
        try{
            listUser = userRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listUser;
    }

    //根据主键id查询user
    @GetMapping(value = "/user/{id}")
    public User getUser (@PathVariable("id") Integer id) {
        return userRepository.findOne(id);
    }

    //新增
    @PostMapping(value = "/add")
    public User addUser(@PathVariable("name") String name,@PathVariable("phone") String phone,@PathVariable("gender") String gender) {
        User user = new User();
        user.setName(name);
        user.setPhone(phone);
        user.setGender(gender);
        return userRepository.save(user);
    }

    //根据id删除user
    @GetMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userRepository.delete(id);
    }

    //根据性别查询user
    @GetMapping(value = "/listbyname/{gender}")
    public List<User> listByGender(@PathVariable("gender") String gender) {
        return userRepository.findByGender(gender);
    }
}
