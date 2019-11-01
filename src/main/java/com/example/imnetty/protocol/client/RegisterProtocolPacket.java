package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户注册协议包
 *
 * @author peter
 * date: 2019-11-01 10:42
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class RegisterProtocolPacket extends ProtocolPacket {

    private String username;

    private String password;

    @Override
    public int command() {
        return CommandEnum.REGISTER.getCommand();
    }

    public static RegisterProtocolPacket of(String username,String password){

        RegisterProtocolPacket registerProtocolPacket = new RegisterProtocolPacket();

        registerProtocolPacket.setPassword(password);
        registerProtocolPacket.setUsername(username);

        return registerProtocolPacket;
    }
}
