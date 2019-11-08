package com.example.imnetty.protocol.client;

import com.example.imnetty.Client;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author peter
 * date: 2019-11-06 15:42
 **/
public class ClientIdleStateHandler extends IdleStateHandler {

    private static final int READER_IDLE_TIME_SECONDS = 60;

    public ClientIdleStateHandler() {
        super(READER_IDLE_TIME_SECONDS, 0, 0);
    }


    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {
    }


    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {

        Client.startClient();

    }
}
