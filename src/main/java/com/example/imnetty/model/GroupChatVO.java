package com.example.imnetty.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author peter
 * date: 2019-11-05 16:38
 **/
@Data
public class GroupChatVO implements Serializable {

    private String groupId;

    private String groupName;

    private String groupAdmin;


    public static GroupChatVO fromEntity(GroupChat chat) {
        GroupChatVO vo = new GroupChatVO();
        vo.setGroupAdmin(chat.getGroupAdmin().getUsername());

        vo.setGroupId(chat.getChatId());

        vo.setGroupName(chat.getGroupName());

        return vo;
    }


}
