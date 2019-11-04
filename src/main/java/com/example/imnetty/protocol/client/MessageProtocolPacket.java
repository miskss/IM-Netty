package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author peter
 * date: 2019-11-04 14:27
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class MessageProtocolPacket extends ProtocolPacket {
    private String toUid;
    private String message;

    @Override
    protected int command() {
        return CommandEnum.MESSAGE.getCommand();
    }

    public static MessageProtocolPacket of(String toUid, String message) {
        MessageProtocolPacket packet = new MessageProtocolPacket();
        packet.setMessage(message);
        packet.setToUid(toUid);

        return packet;
    }

}
