package com.example.imnetty.action;

import com.example.imnetty.protocol.client.LoginProtocolPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-01 16:09
 **/
public class LoginAction implements Action {
    @Override
    public void doCommand(Channel channel) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");

        String password = scanner.nextLine();

        channel.writeAndFlush(LoginProtocolPacket.of(username, password));


    }
}
