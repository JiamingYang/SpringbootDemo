package com.demo2.example.repository;

import com.demo2.example.domain.MysqlUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by asus on 2018/12/12.
 */
@Repository
public interface MysqlUserRepository extends JpaRepository<MysqlUser,Long> {
    MysqlUser findByUserName(String userName);
    MysqlUser findByUserNameOrAge(String username, String email);

    @Query(value = "select u from com.demo2.example.domain.MysqlUser u where u.age=?1")
    MysqlUser findTheLi(int age);
}
