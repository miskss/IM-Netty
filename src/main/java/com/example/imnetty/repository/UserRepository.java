package com.example.imnetty.repository;

import com.example.imnetty.model.UserEntity;

import java.util.List;

/**
 * @author peter
 * date: 2019-11-01 14:28
 **/
public interface UserRepository {

    void save(UserEntity userEntity);

    UserEntity findByUsername(String username);

    UserEntity findByUserId(String uid);

    List<UserEntity> findByUsernameLike(String usernameLike);


}
