package com.fajarnashirul.edi.crud.test.repository;

import com.fajarnashirul.edi.crud.test.model.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {
    @Select("SELECT * FROM user")
    List<UserModel> findAll();
    @Select("SELECT * FROM user WHERE userId = #{userId}")
    Optional<UserModel> findById(Integer userId);
    @Insert("INSERT INTO user (userId, namaLengkap, username, password, status) " +
            " VALUES (#{userId}, #{namaLengkap}, #{username}, #{password}, #{status})")
    Integer save(UserModel userModel);
    @Delete("DELETE FROM user WHERE userId = #{userId}")
    void delete(Integer userId);
    @Select("SELECT COUNT(*) FROM user WHERE username = #{username}")
    Integer existsByUsername(String username);
    @Select("SELECT LAST_INSERT_ID()")
    Integer getLastUserId();
}
