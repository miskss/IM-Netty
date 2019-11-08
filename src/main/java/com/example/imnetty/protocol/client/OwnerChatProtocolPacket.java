package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;

/**
 * @author peter
 * date: 2019-11-06 10:15
 **/
public class OwnerChatProtocolPacket extends ProtocolPacket {
    @Override
    protected int command() {
        return CommandEnum.OWNER_CHAT.getCommand();
    }

    public static OwnerChatProtocolPacket of() {
        OwnerChatProtocolPacket packet= new OwnerChatProtocolPacket();

        return packet;
    }
}
