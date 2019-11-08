package com.example.imnetty;

import com.example.imnetty.action.ConsoleAction;
import com.example.imnetty.commonhandler.ProtocolPacketHandler;
import com.example.imnetty.commonhandler.SpliterHandler;
import com.example.imnetty.protocol.client.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author peter
 * date: 2019-11-01 13:37
 **/
public class Client {
    public static void main(String[] args) {
        startClient();
    }

    public static void startClient() {
        NioEventLoopGroup executors = new NioEventLoopGroup();

        Bootstrap handler = new Bootstrap()
                .group(executors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new ClientIdleStateHandler())
                                .addLast(new SpliterHandler())
                                .addLast(new ProtocolPacketHandler())
                                .addLast(new ResponseRegisterProtocolPacketHandler())
                                .addLast(new ResponseLoginProtocolPacketHandler())
                                .addLast(new HeartBeatFixedSendHandler())
                                .addLast(new ResponseSearchUserProtocolPacketHandler())
                                .addLast(new ResponseFriendsProtocolPacketHandler())
                                .addLast(new SendMessageProtocolPacketHandler())
                                .addLast(new ResponseSearchGroupChatProtocolPacketHandler())
                                .addLast(new ResponseOwnerChatProtocolPacketHandler())
                                .addLast(new GroupMessageToSendProtocolPacketHandler());
                    }
                });

        ChannelFuture connect = handler.connect("127.0.0.1", 8000);
        connect.addListener(future -> {
            if (future.isSuccess()) {
                ConsoleAction.initAction(connect.channel());
            }
        });
    }
}
