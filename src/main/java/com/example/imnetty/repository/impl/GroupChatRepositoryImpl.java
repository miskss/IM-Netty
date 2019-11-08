package com.example.imnetty.repository.impl;

import com.example.imnetty.model.GroupChat;
import com.example.imnetty.redis.RedisKey;
import com.example.imnetty.redis.RedisUtils;
import com.example.imnetty.repository.GroupChatRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author peter
 * date: 2019-11-05 10:32
 **/
public enum GroupChatRepositoryImpl implements GroupChatRepository {
    INSTANCE ;


    @Override
    public void save(GroupChat chat) {
        String key = RedisKey.GROUP_CHAT + chat.getChatId();
        RedisUtils.setStringValue(key, chat);
    }

    @Override
    public void saveUserChatRelation(String uid, String chatId) {
        String key = RedisKey.USER_GROUP_CHAT + uid;
        RedisUtils.setSet(key, chatId);
    }

    @Override
    public GroupChat findByChatId(String chatId) {
        String key = RedisKey.GROUP_CHAT + chatId;
        return (GroupChat) RedisUtils.getStringValue(key);
    }

    @Override
    public List<GroupChat> findByUserId(String uid) {
        String key = RedisKey.USER_GROUP_CHAT + uid;

        Set<Object> set = RedisUtils.getSet(key);

        return set.stream().map(o -> (String) o)
                .map(this::findByChatId)
                .collect(Collectors.toList());
    }


}
