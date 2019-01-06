package com.demo2.example.service;

import com.demo2.example.domain.MysqlUser;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by asus on 2018/12/15.
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    private org.slf4j.Logger logger= LoggerFactory.getLogger(RedisService.class);
    public boolean setFirstObject(String key, Object user){
        boolean flag=false;
        try {
            ValueOperations<Serializable,Object> valueOperations= redisTemplate.opsForValue();
            valueOperations.set(key,user);
            flag=true;
        }catch (Exception e){
            logger.error("set error: key {}, value {}",key,user,e);
        }
        return flag;
    }

    public Object getValue(String key){
        ValueOperations<Serializable,Object> valueOperations= redisTemplate.opsForValue();
        Object result=valueOperations.get(key);
        return result;
    }

}
