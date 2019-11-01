package com.example.imnetty.commonhandler;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.TransferProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @author peter
 * date: 2019-11-01 11:25
 **/
public class ProtocolPacketHandler extends MessageToMessageCodec<ByteBuf, ProtocolPacket> {


    @Override
    protected void encode(ChannelHandlerContext ctx, ProtocolPacket msg, List<Object> out) throws Exception {
        ByteBuf buf = ctx.alloc().ioBuffer();
        TransferProtocol.encode(buf, msg);
        out.add(buf);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        ProtocolPacket decode = TransferProtocol.decode(msg);
        out.add(decode);
    }
}
