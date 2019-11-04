package com.example.imnetty.protocol.client;

import com.example.imnetty.action.AddUserAction;
import com.example.imnetty.action.ConsoleAction;
import com.example.imnetty.action.SendSingleMsgAction;
import com.example.imnetty.model.UserVO;
import com.example.imnetty.protocol.server.ResponseFriendsProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-04 13:53
 **/
public class ResponseFriendsProtocolPacketHandler extends SimpleChannelInboundHandler<ResponseFriendsProtocolPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseFriendsProtocolPacket msg) throws Exception {
        System.out.println("=================          好友列表           ====================");
        System.out.println("=================================================================");
        List<UserVO> users = msg.getUsers();

        System.out.println("序号  \t  好友uid  \t       好友昵称 ");

        for (int i = 0; i < users.size(); i++) {
            UserVO userVO = users.get(i);
            System.out.println((i + 1) + "  \t     " + userVO.getUid() + "  \t        " + userVO.getUsername());
        }

        System.out.println("=================================================================");

        ctx.executor().execute(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请选择操作：");
                System.out.println("1、发送消息 \t 2、返回");
                try {

                    String s = scanner.nextLine();
                    switch (Integer.parseInt(s)) {
                        case 1:
                            new SendSingleMsgAction().doCommand(ctx.channel());
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
