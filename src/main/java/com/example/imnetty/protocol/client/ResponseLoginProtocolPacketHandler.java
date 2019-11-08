package com.example.imnetty.protocol.client;

import com.example.imnetty.action.ConsoleAction;
import com.example.imnetty.protocol.server.ResponseLoginProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author peter
 * date: 2019-11-01 17:30
 **/
public class ResponseLoginProtocolPacketHandler extends SimpleChannelInboundHandler<ResponseLoginProtocolPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseLoginProtocolPacket msg) throws Exception {
        if (msg.reqSuccess()) {
            ConsoleAction.interfaceAction(ctx.channel());
        } else {
            System.out.println("登录失败!!错误信息:" + msg.getErrMsg());
            Thread.sleep(800);
            ConsoleAction.initAction(ctx.channel());
        }

    }
}
