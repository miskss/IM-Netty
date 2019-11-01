package com.example.imnetty.model;

import com.example.imnetty.redis.RedisKey;
import com.example.imnetty.redis.RedisUtils;

/**
 * @author peter
 * date: 2019-11-01 10:51
 **/
public class UserFactory {

    private static final int UID_LENGTH = 8;

    public static UserEntity createUser(String username, String password) {
        String uid = generateUid();

        UserEntity entity = new UserEntity();

        entity.setPassword(password);
        entity.setUsername(username);
        entity.setUid(uid);

        return entity;
    }

    public static String generateUid() {
        String uidKey = RedisKey.UID;
        if (!RedisUtils.hasKey(uidKey)) {
            RedisUtils.setStringValue(uidKey, 0);
        }
        Long uid = RedisUtils.incrString(uidKey);
        return format(uid);
    }

    private static String format(Long uid) {

        String uidtr = String.valueOf(uid);

        if (uidtr.length() < UID_LENGTH) {

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < (UID_LENGTH - uidtr.length()); i++) {
                builder.append('0');
            }
            builder.append(uidtr);

            uidtr = builder.toString();
        }

        return uidtr;
    }

}
