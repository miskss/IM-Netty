package com.example.imnetty.action;

import com.example.imnetty.protocol.client.OwnerChatProtocolPacket;
import io.netty.channel.Channel;

/**
 * @author peter
 * date: 2019-11-05 17:05
 **/
public class OwnerChatAction implements Action {
    @Override
    public void doCommand(Channel channel) {

        channel.writeAndFlush(OwnerChatProtocolPacket.of());


    }
}
