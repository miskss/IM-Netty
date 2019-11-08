package com.example.imnetty.protocol.client;

import com.example.imnetty.action.AddUserAction;
import com.example.imnetty.action.ConsoleAction;
import com.example.imnetty.model.GroupChatVO;
import com.example.imnetty.protocol.server.ResponseSearchGroupChatProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-05 16:45
 **/
public class ResponseSearchGroupChatProtocolPacketHandler extends SimpleChannelInboundHandler<ResponseSearchGroupChatProtocolPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseSearchGroupChatProtocolPacket msg) throws Exception {
        System.out.println("========================================");
        System.out.println("群号 \t 群名称 \t 群主");
        GroupChatVO chat = msg.getChat();
        if (chat == null) {
            System.out.println("未找到群聊！！");

            ConsoleAction.interfaceAction(ctx.channel());
        } else {
            System.out.println(chat.getGroupId() + " \t " + chat.getGroupName() + " \t " + chat.getGroupAdmin());

            ctx.executor().execute(() -> {
                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.println("请选择操作：");
                    System.out.println("1、加入群聊 \t 2、返回");
                    try {

                        String s = scanner.nextLine();
                        switch (Integer.parseInt(s)) {
                            case 1:
                                ctx.writeAndFlush(AddGroupChatProtocolPacket.of(chat.getGroupId()));
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
}
