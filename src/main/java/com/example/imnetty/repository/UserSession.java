package com.example.imnetty.repository;

import io.netty.channel.Channel;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author peter
 * create: 2019-11-04 14:14
 **/
public enum UserSession {
    ;
    private final static ConcurrentHashMap<String, Channel> USERS_CHANNEL = new java.util.concurrent.ConcurrentHashMap<>(16);

    public static void put(String uid, Channel channel) {

        USERS_CHANNEL.put(uid, channel);

    }

    public static Channel getChannel(String uid) {
        return USERS_CHANNEL.get(uid);
    }

    public static void remove(String uid) {

        USERS_CHANNEL.remove(uid);
    }
}
