package com.example.imnetty.protocol.server;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author peter
 * date: 2019-11-01 10:49
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseRegisterProtocolPacket extends ProtocolPacket {

    private int code;

    private String uid;

    private String errMsg;


    public boolean reqSuccess() {
        return this.code == 200;
    }

    public static ResponseRegisterProtocolPacket success(String uid) {

        ResponseRegisterProtocolPacket packet = new ResponseRegisterProtocolPacket();

        packet.setCode(200);
        packet.setErrMsg(null);
        packet.setUid(uid);
        return packet;

    }

    public static ResponseRegisterProtocolPacket fail(String errMsg) {

        ResponseRegisterProtocolPacket packet = new ResponseRegisterProtocolPacket();
        packet.setCode(400);
        packet.setErrMsg(errMsg);
        packet.setUid(null);
        return packet;

    }

    @Override
    protected int command() {
        return CommandEnum.RESPONSE_REGISTER.getCommand();
    }
}
