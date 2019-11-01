package com.example.imnetty.protocol;

import com.example.imnetty.protocol.command.CommandEnum;
import com.google.gson.Gson;
import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

/**
 * 传输协议定义
 * <p>
 * 魔数 (4 字节) + 协议的版本号（1字节） + 指令 （2字节）+数据的长度（4 字节） + 数据载体（n 字节）
 * 数据为json格式 ，协议的版本 暂时固定为 1
 * <p>
 * +------------+---------+------------+--------------+----------------+
 * | 0xCAFE1234 | 1 byte  |  2 bytes   |    4 bytes   |   1....n bytes |
 * +------------+---------+------------+--------------+----------------+
 *
 * @author peter
 * date: 2019-11-01 09:34
 **/
public class TransferProtocol {

    public static final int MAGIC_NUM = 0xCAFE1234;

    private static final int VERSION = 1;

    private static Gson gson = new Gson();

    public static void encode(ByteBuf buf, ProtocolPacket data) {

        buf.writeInt(MAGIC_NUM);

        buf.writeByte(VERSION);

        buf.writeShort(data.command());

        String json = gson.toJson(data);

        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);

        buf.writeInt(bytes.length);

        buf.writeBytes(bytes);

    }


    public static ProtocolPacket decode(ByteBuf buf) {

        buf.skipBytes(4);//忽略魔数

        buf.skipBytes(1);//忽略版本号

        short command = buf.readShort();

        Class<? extends ProtocolPacket> packetClass = CommandEnum.getPacketClass(command);

        int dataLength = buf.readInt();

        byte[] data = new byte[dataLength];

        buf.readBytes(data);

        String dataString = new String(data, StandardCharsets.UTF_8);

        return gson.fromJson(dataString, packetClass);
    }

}
