package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-06 15:45
 **/
@Data
public class HeartBeatProtocolPacket extends ProtocolPacket {
    private String beat;


    @Override
    protected int command() {
        return CommandEnum.HEART_BEAT.getCommand();
    }

    public static HeartBeatProtocolPacket of(String beat) {
        HeartBeatProtocolPacket heartBeatProtocolPacket = new HeartBeatProtocolPacket();

        heartBeatProtocolPacket.setBeat(beat);
        return heartBeatProtocolPacket;
    }
}
