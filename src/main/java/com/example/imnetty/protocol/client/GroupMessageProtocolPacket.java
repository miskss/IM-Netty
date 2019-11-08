package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-06 10:30
 **/
@Data
public class GroupMessageProtocolPacket extends ProtocolPacket {

    private String chatId;

    private String msg;

    @Override
    protected int command() {
        return CommandEnum.GROUP_MESSAGE.getCommand();
    }

    public static GroupMessageProtocolPacket of(String chatId, String msg) {
        GroupMessageProtocolPacket packet = new GroupMessageProtocolPacket();
        packet.setChatId(chatId);
        packet.setMsg(msg);
        return packet;
    }
}
