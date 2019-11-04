package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;

/**
 * @author peter
 * date: 2019-11-04 09:58
 **/
public class AuthHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Attribute<Boolean> attr = ctx.channel().attr(SessionAttributeKey.AUTH);

        Boolean aBoolean = attr.get();
        if (aBoolean == null || !aBoolean) {
            ctx.channel().close();
            return;
        }
        super.channelRead(ctx, msg);
    }
}
