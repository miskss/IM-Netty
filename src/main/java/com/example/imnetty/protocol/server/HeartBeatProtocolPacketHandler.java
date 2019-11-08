package com.example.imnetty.protocol.server;

import com.example.imnetty.protocol.client.HeartBeatProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author peter
 * date: 2019-11-06 15:47
 **/
@Slf4j
public class HeartBeatProtocolPacketHandler extends SimpleChannelInboundHandler<HeartBeatProtocolPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HeartBeatProtocolPacket msg) throws Exception {
        log.info("收到心跳包");
        ctx.writeAndFlush(HeartBeatProtocolPacket.of("pong"));
    }
}
