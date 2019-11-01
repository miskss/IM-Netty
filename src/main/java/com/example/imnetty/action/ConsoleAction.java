package com.example.imnetty.action;


import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author peter
 * date: 2019-11-01 13:50
 **/
public class ConsoleAction {

    public static void initAction(Channel channel) {

        System.out.println("===============  欢迎使用 XXX IM 聊天系统  =================");
        Scanner scanner = new Scanner(System.in);
        initShow(scanner).doCommand(channel);

    }

    private static Action initShow(Scanner scanner) {

        System.out.println("==================================================");
        System.out.println("===============   请选择操作    ===================");
        System.out.println("===============   1、注册       ===================");
        System.out.println("===============   2、登录       ===================");
        System.out.println("==================================================");

        try {


            String str = scanner.nextLine();

            switch (Integer.parseInt(str)) {
                case 1:
                    return new RegisterAction();
                case 2:
                    return new LoginAction();
                default:
                    return initShow(scanner);
            }
        } catch (Exception e) {
            return initShow(scanner);
        }
    }
}
