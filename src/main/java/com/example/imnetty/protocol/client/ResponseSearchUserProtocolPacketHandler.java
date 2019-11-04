package com.example.imnetty.protocol.client;

import com.example.imnetty.action.AddUserAction;
import com.example.imnetty.action.ConsoleAction;
import com.example.imnetty.model.UserVO;
import com.example.imnetty.protocol.server.ResponseSearchUserProtocolPacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-04 10:02
 **/
public class ResponseSearchUserProtocolPacketHandler extends SimpleChannelInboundHandler<ResponseSearchUserProtocolPacket> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ResponseSearchUserProtocolPacket msg) throws Exception {
        List<UserVO> users = msg.getUsers();

        System.out.println("=================================================");


        System.out.println("序号  \t  uid  \t             用户名");

        for (int i = 0; i < users.size(); i++) {
            UserVO userVO = users.get(i);
            System.out.println((i + 1) + "  \t  " + userVO.getUid() + "  \t   " + userVO.getUsername());
        }

        System.out.println("总查找到" + users.size() + "条记录");

        ctx.executor().execute(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("请选择操作：");
                System.out.println("1、添加 \t 2、返回");
                try {

                    String s = scanner.nextLine();
                    switch (Integer.parseInt(s)) {
                        case 1:
                            new AddUserAction().doCommand(ctx.channel());
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
