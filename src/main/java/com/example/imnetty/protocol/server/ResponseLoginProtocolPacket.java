package com.example.imnetty.protocol.server;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-01 16:40
 **/
@Data
public class ResponseLoginProtocolPacket extends ProtocolPacket {

    private int code;

    private String errMsg;
    public boolean reqSuccess() {
        return this.code == 200;
    }

    public static ResponseLoginProtocolPacket success() {

        ResponseLoginProtocolPacket packet = new ResponseLoginProtocolPacket();

        packet.setCode(200);
        packet.setErrMsg(null);
        return packet;

    }

    public static ResponseLoginProtocolPacket fail(String errMsg) {

        ResponseLoginProtocolPacket packet = new ResponseLoginProtocolPacket();
        packet.setCode(400);
        packet.setErrMsg(errMsg);
        return packet;

    }

    @Override
    protected int command() {
        return CommandEnum.RESPONSE_LOGIN.getCommand();
    }
}
