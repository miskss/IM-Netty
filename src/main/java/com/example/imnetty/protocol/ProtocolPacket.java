package com.example.imnetty.protocol;

/**
 * 协议中的数据包
 *
 * @author peter
 * date: 2019-11-01 10:10
 **/
public abstract class ProtocolPacket {
    protected abstract int command();
}
