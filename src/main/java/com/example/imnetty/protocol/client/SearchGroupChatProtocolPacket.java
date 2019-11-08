package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-05 16:11
 **/
@Data
public class SearchGroupChatProtocolPacket extends ProtocolPacket {

    private String groupId;

    @Override
    protected int command() {
        return CommandEnum.SEARCH_GROUP.getCommand();
    }

    public static SearchGroupChatProtocolPacket of(String groupId) {
        SearchGroupChatProtocolPacket packet = new SearchGroupChatProtocolPacket();
        packet.setGroupId(groupId);
        return packet;
    }
}
