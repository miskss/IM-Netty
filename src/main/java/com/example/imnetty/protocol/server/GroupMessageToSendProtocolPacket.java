package com.example.imnetty.protocol.server;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-06 10:42
 **/
@Data
public class GroupMessageToSendProtocolPacket extends ProtocolPacket {
    private String chatId;

    private String groupName;


    private String fromUser;


    private String msg;


    @Override
    protected int command() {
        return CommandEnum.GROUP_MESSAGE_TO_SEND.getCommand();
    }


    public static GroupMessageToSendProtocolPacket of(String chatId, String groupName, String fromUser, String msg) {
        GroupMessageToSendProtocolPacket packet = new GroupMessageToSendProtocolPacket();
        packet.setChatId(chatId);
        packet.setGroupName(groupName);
        packet.setFromUser(fromUser);
        packet.setMsg(msg);




        return packet;
    }
}
