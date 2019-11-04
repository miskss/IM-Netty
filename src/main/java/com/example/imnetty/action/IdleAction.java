package com.example.imnetty.action;

import io.netty.channel.Channel;

/**
 * @author peter
 * date: 2019-11-04 15:32
 **/
public class IdleAction implements Action{
    @Override
    public void doCommand(Channel channel) {
        System.out.println("查看消息");
    }
}
