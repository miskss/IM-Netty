package com.example.imnetty.action;

import com.example.imnetty.protocol.client.AddUserProtocolPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-04 10:18
 **/
public class AddUserAction implements Action {
    @Override
    public void doCommand(Channel channel) {
        System.out.println("请输入要添加的用户uid：");

        Scanner scanner = new Scanner(System.in);

        String search = scanner.nextLine();

        channel.writeAndFlush(AddUserProtocolPacket.of(search));


        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ConsoleAction.interfaceAction(channel);
    }
}
