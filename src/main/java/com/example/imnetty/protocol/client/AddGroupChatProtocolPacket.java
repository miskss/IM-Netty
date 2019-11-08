package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-05 16:50
 **/
@Data
public class AddGroupChatProtocolPacket extends ProtocolPacket {

    private String groupId;
    @Override
    protected int command() {
        return CommandEnum.JOIN_GROUP.getCommand();
    }

    public static AddGroupChatProtocolPacket of(String groupId) {
        AddGroupChatProtocolPacket packet = new AddGroupChatProtocolPacket();

        packet.setGroupId(groupId);

        return packet;
    }
}
