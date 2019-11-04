package com.example.imnetty.protocol.client;

import com.example.imnetty.action.AddUserAction;
import com.example.imnetty.action.ConsoleAction;
import com.example.imnetty.protocol.server.SendMessageProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-04 14:44
 **/
@Slf4j
public class SendMessageProtocolPacketHandler extends SimpleChannelInboundHandler<SendMessageProtocolPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SendMessageProtocolPacket msg) throws Exception {

        System.out.println("=======================================");

        System.out.println("收到来自好友【" + msg.getFromUsername() + "】的消息：");

        System.out.println(msg.getMsg());

        System.out.println("=======================================");


        ctx.executor().execute(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("是否要回复：");
                System.out.println("1、是 \t 2、否");
                try {

                    String s = scanner.nextLine();
                    switch (Integer.parseInt(s)) {
                        case 1:
                            System.out.println("请输入要发送的消息：");
                            String message = scanner.nextLine();
                            ctx.writeAndFlush(MessageProtocolPacket.of(msg.getFromUid(), message));
                            return;
                        case 2:
                            ConsoleAction.interfaceAction(ctx.channel());
                            return;
                        default:
                    }

                } catch (Exception e) {
                }
            }
        });

    }
}
