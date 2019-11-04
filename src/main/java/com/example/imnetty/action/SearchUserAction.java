package com.example.imnetty.action;

import com.example.imnetty.protocol.client.SearchUserProtocolPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-04 09:35
 **/
public class SearchUserAction implements Action {
    @Override
    public void doCommand(Channel channel) {

        System.out.println("请输入要搜索的用户名称或id：");

        Scanner scanner = new Scanner(System.in);

        String search = scanner.nextLine();

        channel.writeAndFlush(SearchUserProtocolPacket.of(search));

    }
}
