package com.example.imnetty.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 群聊
 *
 * @author peter
 * date: 2019-11-05 09:04
 **/
@Data
public class GroupChat implements Serializable {

    private static final long serialVersionUID = 3459075553084868485L;


    private String chatId;

    private String groupName;

    private Set<UserEntity> users;


    private UserEntity groupAdmin;


    public static GroupChat create(String groupName, UserEntity groupAdmin) {
        GroupChat chat = new GroupChat();
        chat.setChatId(UserFactory.generateUid());
        chat.setGroupAdmin(groupAdmin);
        chat.setGroupName(groupName);
        HashSet<UserEntity> users = new HashSet<>(16);
        users.add(groupAdmin);
        chat.setUsers(users);
        return chat;
    }


    public void addMember(UserEntity member) {
        this.users.add(member);
    }

    public void addMembers(Collection<UserEntity> members) {
        this.users.addAll(members);
    }

}
