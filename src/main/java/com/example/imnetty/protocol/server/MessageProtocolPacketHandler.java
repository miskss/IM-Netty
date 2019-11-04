package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import com.example.imnetty.model.UserEntity;
import com.example.imnetty.protocol.client.MessageProtocolPacket;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.UserSession;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author peter
 * date: 2019-11-04 14:32
 **/
public class MessageProtocolPacketHandler extends SimpleChannelInboundHandler<MessageProtocolPacket> {

    private UserRepository userRepository = UserRepositoryImpl.INSTANCE;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocolPacket msg) throws Exception {
        String toUid = msg.getToUid();
        Channel channel = UserSession.getChannel(toUid);

        if (channel == null) return;

        String uid = ctx.channel().attr(SessionAttributeKey.UID).get();

        UserEntity byUserId = userRepository.findByUserId(uid);

        if (byUserId == null) return;

        channel.writeAndFlush(SendMessageProtocolPacket.of(byUserId.getUid(),byUserId.getUsername(),msg.getMessage()));
    }
}
