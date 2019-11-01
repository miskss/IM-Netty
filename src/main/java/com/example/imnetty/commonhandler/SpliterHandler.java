package com.example.imnetty.commonhandler;

import com.example.imnetty.protocol.TransferProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 拆包
 *
 * @author peter
 * date: 2019-11-01 16:22
 **/
public class SpliterHandler extends LengthFieldBasedFrameDecoder {

    public SpliterHandler() {
        super(Integer.MAX_VALUE, 7, 4);
    }


    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        int anInt = in.getInt(in.readerIndex());
        if (anInt != TransferProtocol.MAGIC_NUM) {
            ctx.channel().close();
            return null;
        }


        return super.decode(ctx, in);
    }
}
