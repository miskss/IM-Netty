package com.example.imnetty;

import com.example.imnetty.commonhandler.ProtocolPacketHandler;
import com.example.imnetty.commonhandler.SpliterHandler;
import com.example.imnetty.protocol.server.*;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ImNettyApplication {

    private static int inetPort = 8000;


    public static void main(String[] args) {
        SpringApplication.run(ImNettyApplication.class, args);

        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        new ServerBootstrap()
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        nioSocketChannel.pipeline()
                                .addLast(new IdleStateHandler())
                                .addLast(new SpliterHandler())
                                .addLast(new ProtocolPacketHandler())
                                .addLast(new RegisterProtocolPacketHandler())
                                .addLast(new LoginProtocolPacketHandler())
                                .addLast(new AuthHandler())
                                .addLast(new HeartBeatProtocolPacketHandler())
                                .addLast(new SearchUserProtocolPacketHandler())
                                .addLast(new AddUserProtocolPacketHandler())
                                .addLast(new FriendsProtocolPacketHandler())
                                .addLast(new MessageProtocolPacketHandler())
                                .addLast(new CreateGroupProtocolPacketHandler())
                                .addLast(new SearchGroupChatProtocolPacketHandler())
                                .addLast(new AddGroupChatProtocolPacketHandler())
                                .addLast(new GroupMessageProtocolPacketHandler())
                                .addLast(new OwnerChatProtocolPacketHandler())

                        ;
                    }
                }).bind(inetPort).addListener(future -> {
            if (future.isSuccess()) {
                log.info("netty 服务端启动成功！！ 绑定端口：{}", inetPort);
            }
        });


    }

}
