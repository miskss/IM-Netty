package com.example.imnetty.protocol.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author peter
 * date: 2019-11-04 15:47
 **/
public class IdleStateHandler extends io.netty.handler.timeout.IdleStateHandler {


    private static final int READER_IDLE_TIME_SECONDS = 60;

    public IdleStateHandler() {
        super(READER_IDLE_TIME_SECONDS, 0, 0);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
        System.out.println("在" + READER_IDLE_TIME_SECONDS + "秒内未读到数据，关闭连接");

        ctx.channel().close();

        super.channelIdle(ctx, evt);
    }
}
