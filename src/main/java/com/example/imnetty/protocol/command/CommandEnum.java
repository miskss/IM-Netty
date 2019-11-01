package com.example.imnetty.protocol.command;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.client.LoginProtocolPacket;
import com.example.imnetty.protocol.client.RegisterProtocolPacket;
import com.example.imnetty.protocol.server.ResponseLoginProtocolPacket;
import com.example.imnetty.protocol.server.ResponseRegisterProtocolPacket;

/**
 * @author peter
 * date: 2019-11-01 10:15
 **/
public enum CommandEnum {
    REGISTER(1, RegisterProtocolPacket.class),
    RESPONSE_REGISTER(2, ResponseRegisterProtocolPacket.class),

    LOGIN(3, LoginProtocolPacket.class),
    RESPONSE_LOGIN(4, ResponseLoginProtocolPacket.class)


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
