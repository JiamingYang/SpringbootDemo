package com.demo2.example.controller;

import com.demo2.example.domain.MysqlUser;
import com.demo2.example.mapper.MysqlUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by asus on 2018/12/17.
 */
@RestController
public class MybatisContoller {
    @Resource
    @Autowired
    private MysqlUserMapper mysqlUserMapper;
    @RequestMapping("/firstMybatis")
    public MysqlUser addSingleUser(){
//        MysqlUser mysqlUser=new MysqlUser();
//        mysqlUser.setAge(64);
//        mysqlUser.setId(new Long(1234999));
//        mysqlUser.setUserName("mybatis测试者2");
//        mysqlUser.setPass("12377");
//        mysqlUserMapper.insert(mysqlUser);
        MysqlUser result= mysqlUserMapper.getOne(new Long(1234999));
        return result;
    }
}
