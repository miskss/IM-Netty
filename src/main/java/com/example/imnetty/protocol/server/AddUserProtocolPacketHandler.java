package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import com.example.imnetty.protocol.client.AddUserProtocolPacket;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.util.StringUtils;

/**
 * @author peter
 * date: 2019-11-04 11:02
 **/
public class AddUserProtocolPacketHandler extends SimpleChannelInboundHandler<AddUserProtocolPacket> {
    private UserRepository userRepository = UserRepositoryImpl.INSTANCE;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddUserProtocolPacket msg) throws Exception {
        String uid = ctx.channel().attr(SessionAttributeKey.UID).get();

        if (StringUtils.isEmpty(uid)) return;
        userRepository.saveUserFriend(uid,msg.getUid());
    }
}
