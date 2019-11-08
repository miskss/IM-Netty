package com.example.imnetty.protocol.command;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.client.*;
import com.example.imnetty.protocol.server.*;

/**
 * @author peter
 * date: 2019-11-01 10:15
 **/
public enum CommandEnum {
    REGISTER(1, RegisterProtocolPacket.class),
    RESPONSE_REGISTER(2, ResponseRegisterProtocolPacket.class),

    LOGIN(3, LoginProtocolPacket.class),
    RESPONSE_LOGIN(4, ResponseLoginProtocolPacket.class),

    SEARCH_USER(5, SearchUserProtocolPacket.class),
    RESPONSE_SEARCH_USER(6, ResponseSearchUserProtocolPacket.class),

    ADD_USER(7, AddUserProtocolPacket.class),

    FRIENDS(8, FriendsProtocolPacket.class),
    RESPONSE_FRIEND(9, ResponseFriendsProtocolPacket.class),

    MESSAGE(10, MessageProtocolPacket.class),
    SEND_MESSAGE(11, SendMessageProtocolPacket.class),

    GROUP(12, CreateGroupProtocolPacket.class),
    SEARCH_GROUP(13, SearchGroupChatProtocolPacket.class),
    RESPONSE_SEARCH_GROUP(14, ResponseSearchGroupChatProtocolPacket.class),
    JOIN_GROUP(15, AddGroupChatProtocolPacket.class),
    OWNER_CHAT(16, OwnerChatProtocolPacket.class),
    RESPONSE_OWNER_CHAT(17, ResponseOwnerChatProtocolPacket.class),

    GROUP_MESSAGE(18,GroupMessageProtocolPacket.class),
    GROUP_MESSAGE_TO_SEND(19,GroupMessageToSendProtocolPacket.class),

    HEART_BEAT(20,HeartBeatProtocolPacket.class)
    ;

    private int command;

    private Class<? extends ProtocolPacket> packetClass;

    CommandEnum(int command, Class<? extends ProtocolPacket> packetClass) {
        this.command = command;
        this.packetClass = packetClass;
    }


    public static Class<? extends ProtocolPacket> getPacketClass(int command) {

        CommandEnum[] values = CommandEnum.values();

        for (CommandEnum value : values) {

            if (value.command == command) {
                return value.packetClass;
            }
        }

        throw new IllegalStateException("unknown command");

    }

    public int getCommand() {
        return command;
    }
}
