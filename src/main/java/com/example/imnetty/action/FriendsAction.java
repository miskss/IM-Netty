package com.example.imnetty.action;

import com.example.imnetty.protocol.client.FriendsProtocolPacket;
import io.netty.channel.Channel;

/**
 * @author peter
 * date: 2019-11-04 13:40
 **/
public class FriendsAction implements Action {
    @Override
    public void doCommand(Channel channel) {
        channel.writeAndFlush(FriendsProtocolPacket.of());
    }
}
