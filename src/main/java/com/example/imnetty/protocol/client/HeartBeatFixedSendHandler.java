package com.example.imnetty.protocol.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author peter
 * date: 2019-11-06 16:38
 **/
@Slf4j
public class HeartBeatFixedSendHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.executor().scheduleAtFixedRate(()->{
            log.info(LocalDateTime.now()+"发送心跳包");
            ctx.channel().writeAndFlush(HeartBeatProtocolPacket.of("ping"));
        },0,1, TimeUnit.SECONDS);
    }
}
