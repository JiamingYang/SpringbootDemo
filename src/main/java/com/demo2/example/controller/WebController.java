package com.demo2.example.controller;

import com.demo2.example.domain.MysqlUser;
import com.demo2.example.domain.User;
import com.demo2.example.repository.MysqlUserRepository;
import com.demo2.example.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by asus on 2018/12/10.
 */
@RestController
public class WebController {
    @Resource
    @Autowired
    private MysqlUserRepository mysqlUserRepository;

    @Autowired
    private RedisService redisService;
    @RequestMapping("/needUser")
    public User getUser(){
        User user=new User();
        user.setAge(10);
        user.setName("mmmuuu");
        user.setPass("konspass");
        return user;
    }
    @RequestMapping(value="get/{name}", method= RequestMethod.GET)
    public User get(@PathVariable String name) {
        User user=new User();
        user.setName(name);
        user.setPass("ValidatName");
        return user;
    }
    @RequestMapping(value="getMysql/{name}", method= RequestMethod.GET)
    public MysqlUser getMysql(@PathVariable String name) {
        MysqlUser user= mysqlUserRepository.findTheLi(20);

        return user;
    }
    @RequestMapping(value="/getFromRedis", method= RequestMethod.GET)
    public MysqlUser getFromRedis() {
        MysqlUser mysqlUser=new MysqlUser();
        mysqlUser.setPass("123");
        mysqlUser.setUserName("闹着玩");
        mysqlUser.setId(new Long(666));
        mysqlUser.setAge(5665);
        String keyValue="firstIndex";
        boolean flag= redisService.setFirstObject(keyValue,mysqlUser);
        MysqlUser obj=new MysqlUser();
        if(flag){
            obj=(MysqlUser)redisService.getValue(keyValue);
        }
        return obj;
    }
}
