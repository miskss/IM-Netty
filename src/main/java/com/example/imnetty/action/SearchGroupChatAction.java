package com.example.imnetty.action;

import com.example.imnetty.protocol.client.SearchGroupChatProtocolPacket;
import com.example.imnetty.protocol.client.SearchUserProtocolPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-05 16:10
 **/
public class SearchGroupChatAction implements Action {
    @Override
    public void doCommand(Channel channel) {
        System.out.println("请输入群id:");
        Scanner scanner = new Scanner(System.in);
        String groupId = scanner.nextLine();
        channel.writeAndFlush(SearchGroupChatProtocolPacket.of(groupId));

    }
}
