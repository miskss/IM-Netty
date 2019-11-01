package com.example.imnetty.action;

import io.netty.channel.Channel;

/**
 * @author peter
 * create: 2019-11-01 13:50
 **/
public interface Action {

    void doCommand(Channel channel);

}
