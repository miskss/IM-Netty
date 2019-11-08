package com.example.imnetty.action;

import com.example.imnetty.protocol.client.CreateGroupProtocolPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-04 15:41
 **/
public class CreateGroupChatAction implements Action {
    @Override
    public void doCommand(Channel channel) {
        System.out.println("请输入群名称");
        Scanner scanner = new Scanner(System.in);
        String groupName = scanner.nextLine();
        channel.writeAndFlush(CreateGroupProtocolPacket.of(groupName));
        ConsoleAction.interfaceAction(channel);
    }
}
