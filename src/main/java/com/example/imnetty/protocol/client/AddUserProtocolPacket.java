package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.*;

/**
 * @author peter
 * date: 2019-11-04 10:36
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class AddUserProtocolPacket extends ProtocolPacket {
    private String uid;

    @Override
    protected int command() {
        return CommandEnum.ADD_USER.getCommand();
    }

    public static AddUserProtocolPacket of(String uid){
        AddUserProtocolPacket packet = new AddUserProtocolPacket();
        packet.setUid(uid);
        return packet;
    }




}
