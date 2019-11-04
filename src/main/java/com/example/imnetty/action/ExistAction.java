package com.example.imnetty.action;

import io.netty.channel.Channel;

/**
 * @author peter
 * date: 2019-11-04 15:33
 **/
public class ExistAction implements Action {
    @Override
    public void doCommand(Channel channel) {
        System.out.println("正在退出。。。。。");
        channel.eventLoop().shutdownGracefully().addListener(future -> {
            System.out.println("已退出系统");
        });
    }
}
