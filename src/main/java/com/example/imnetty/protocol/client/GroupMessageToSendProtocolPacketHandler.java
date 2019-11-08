package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.server.GroupMessageToSendProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author peter
 * date: 2019-11-06 10:48
 **/
public class GroupMessageToSendProtocolPacketHandler extends SimpleChannelInboundHandler<GroupMessageToSendProtocolPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageToSendProtocolPacket msg) throws Exception {
        System.out.println("===================================");

        System.out.println("========== 收到群消息 ==============");

        System.out.println("群【"+msg.getChatId() +":"+msg.getGroupName()+"】用户【"+msg.getFromUser()+"】:");

        System.out.println(msg.getMsg());

    }
}
