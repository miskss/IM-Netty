package com.example.imnetty.protocol.client;

import com.example.imnetty.action.ConsoleAction;
import com.example.imnetty.model.GroupChatVO;
import com.example.imnetty.protocol.server.ResponseOwnerChatProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-06 10:24
 **/
public class ResponseOwnerChatProtocolPacketHandler extends SimpleChannelInboundHandler<ResponseOwnerChatProtocolPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseOwnerChatProtocolPacket msg) throws Exception {
        List<GroupChatVO> chats = msg.getChats();


        System.out.println("========================================");
        System.out.println("群号 \t 群名称 \t 群主");

        chats.forEach(chat -> {
            System.out.println(chat.getGroupId() + " \t " + chat.getGroupName() + " \t " + chat.getGroupAdmin());

        });
        ctx.executor().execute(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请选择操作：");
                System.out.println("1、发送群聊消息 \t 2、返回");
                try {

                    String s = scanner.nextLine();
                    switch (Integer.parseInt(s)) {
                        case 1:
                            System.out.println("请输入要发送的消息：");
                            String message = scanner.nextLine();

                            System.out.println("请输入群号：");

                            String chatId = scanner.nextLine();
                            ctx.writeAndFlush(GroupMessageProtocolPacket.of(chatId, message));

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

