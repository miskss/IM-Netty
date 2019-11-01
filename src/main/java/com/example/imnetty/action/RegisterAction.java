package com.example.imnetty.action;

import com.example.imnetty.protocol.client.RegisterProtocolPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * 注册
 *
 * @author peter
 * date: 2019-11-01 13:51
 **/

public class RegisterAction implements Action {


    @Override
    public void doCommand(Channel channel) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入用户名：");
        String username = scanner.nextLine();

        System.out.println("请输入密码：");

        String password = scanner.nextLine();

        channel.writeAndFlush(RegisterProtocolPacket.of(username, password));
    }
}
