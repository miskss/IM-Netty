package com.example.imnetty.redis;

/**
 * @author peter
 * create: 2019-06-05 09:08
 **/
public interface RedisKey {

    /**
     * 全局数据存储的key前缀
     */
    String PREFIX_KEY = "im:data:";


    String UID = "uid";

    String USER = "user:";

    String USER_FRIEND = "friend:";


}
