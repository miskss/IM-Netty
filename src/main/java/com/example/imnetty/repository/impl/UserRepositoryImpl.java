package com.example.imnetty.repository.impl;

import com.example.imnetty.model.UserEntity;
import com.example.imnetty.redis.RedisKey;
import com.example.imnetty.redis.RedisUtils;
import com.example.imnetty.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author peter
 * date: 2019-11-01 14:31
 **/
public enum UserRepositoryImpl implements UserRepository {
    INSTANCE;

    private Set<UserEntity> findAll() {
        Set<String> set = RedisUtils.getPatternKeys(RedisUtils.getKey(RedisKey.USER) + "*");
        return set.stream().map(key -> (UserEntity) RedisUtils.getValue(key))
                .collect(Collectors.toSet());
    }

    @Override
    public void save(UserEntity userEntity) {
        RedisUtils.setStringValue(RedisKey.USER + userEntity.getUid(), userEntity);
    }

    @Override
    public UserEntity findByUsername(String username) {
        Optional<UserEntity> first = findAll().stream().filter(user -> Objects.equals(user.getUsername(), username))
                .findFirst();
        return first.orElse(null);
    }

    @Override
    public UserEntity findByUserId(String uid) {
        return (UserEntity) RedisUtils.getStringValue(uid);
    }

    @Override
    public List<UserEntity> findByUsernameLike(String usernameLike) {
        return findAll().stream()
                .filter(user -> user.getUsername().contains(usernameLike))
                .collect(Collectors.toList());
    }
}
