package com.example.imnetty.protocol.client;

import com.example.imnetty.action.ConsoleAction;
import com.example.imnetty.protocol.server.ResponseRegisterProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author peter
 * date: 2019-11-01 14:47
 **/
public class ResponseRegisterProtocolPacketHandler extends SimpleChannelInboundHandler<ResponseRegisterProtocolPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseRegisterProtocolPacket msg) throws Exception {

        if (msg.reqSuccess()) {
            System.out.println("恭喜注册 成功！！");
            System.out.println("系统分配的id为【" + msg.getUid() + "】");
        } else {

            System.out.println("注册失败!!错误信息:" + msg.getErrMsg());
        }
        Thread.sleep(1000);
        ConsoleAction.initAction(ctx.channel());
    }
}
