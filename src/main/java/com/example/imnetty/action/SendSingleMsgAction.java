package com.example.imnetty.action;

import com.example.imnetty.protocol.client.MessageProtocolPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-04 13:57
 **/
public class SendSingleMsgAction implements Action {
    @Override
    public void doCommand(Channel channel) {

        System.out.println("请输入好友的uid：");

        Scanner scanner = new Scanner(System.in);

        String uid = scanner.nextLine();
        System.out.println("请输入要发送的消息：");
        String msg = scanner.nextLine();

        channel.writeAndFlush(MessageProtocolPacket.of(uid, msg));

    }
}
