package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-01 14:16
 **/

@Data
public class LoginProtocolPacket extends ProtocolPacket {

    private String username;

    private String password;


    @Override
    protected int command() {
        return CommandEnum.LOGIN.getCommand();
    }

    public static LoginProtocolPacket of(String username, String password) {

        LoginProtocolPacket packet = new LoginProtocolPacket();
        packet.setPassword(password);
        packet.setUsername(username);

        return packet;
    }
}
