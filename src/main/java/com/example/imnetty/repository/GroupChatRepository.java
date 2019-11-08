package com.example.imnetty.repository;

import com.example.imnetty.model.GroupChat;

import java.util.List;

/**
 * @author peter
 * create: 2019-11-05 10:30
 **/
public interface GroupChatRepository {

    void save(GroupChat chat);

    void saveUserChatRelation(String uid, String chatId);

    GroupChat findByChatId(String chatId);

    List<GroupChat> findByUserId(String uid);
}
