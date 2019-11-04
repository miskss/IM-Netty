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

    public static void interfaceAction(Channel channel) {

        Scanner scanner = new Scanner(System.in);
        showFunc(scanner).doCommand(channel);


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


    private static Action showFunc(Scanner scanner) {
        System.out.println("==================================================");
        System.out.println("===============   请选择操作         ==============");
        System.out.println("===============   1、好友列表        ==============");
        System.out.println("===============   2、搜索添加        ==============");
        System.out.println("===============   3、创建群          ==============");
        System.out.println("===============   4、搜索群          ==============");
        System.out.println("===============   5、查看所加入的群   ==============");
        System.out.println("===============   6、查看消息         ==============");
        System.out.println("===============   7、退出             ==============");
        System.out.println("===================================================");
        try {
            String str = scanner.nextLine();
            switch (Integer.parseInt(str)) {
                case 1:
                    return new FriendsAction();
                case 2:
                    return new SearchUserAction();
                case 3:
                case 4:
                case 5:
                case 6:
                    return new IdleAction();
                case 7:
                    return new ExistAction();
                default:
                    return showFunc(scanner);
            }

        } catch (Exception e) {
            return showFunc(scanner);
        }
    }


}
