package com.example.imnetty.protocol.server;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-04 14:33
 **/
@Data
public class SendMessageProtocolPacket extends ProtocolPacket {
    private String fromUid;

    private String fromUsername;

    private String msg;


    @Override
    protected int command() {
        return CommandEnum.SEND_MESSAGE.getCommand();
    }

    public static SendMessageProtocolPacket of(String fromUid,String fromUsername,String msg) {
        SendMessageProtocolPacket packet = new SendMessageProtocolPacket();
        packet.setFromUid(fromUid);
        packet.setFromUsername(fromUsername);
        packet.setMsg(msg);



        return packet;
    }
}
