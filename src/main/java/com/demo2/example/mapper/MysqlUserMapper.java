package com.demo2.example.mapper;

import com.demo2.example.domain.MysqlUser;

import java.util.List;

/**
 * Created by asus on 2018/12/17.
 */
public interface MysqlUserMapper {
    List<MysqlUser> getAll();

    MysqlUser getOne(Long id);

    void insert(MysqlUser user);

    void update(MysqlUser user);

    void delete(Long id);
}
