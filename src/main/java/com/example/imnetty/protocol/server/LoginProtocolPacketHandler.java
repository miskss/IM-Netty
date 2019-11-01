package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import com.example.imnetty.model.UserEntity;
import com.example.imnetty.protocol.client.LoginProtocolPacket;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Objects;

/**
 * @author peter
 * date: 2019-11-01 16:12
 **/
public class LoginProtocolPacketHandler extends SimpleChannelInboundHandler<LoginProtocolPacket> {
    private UserRepository userRepository = UserRepositoryImpl.INSTANCE;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginProtocolPacket msg) throws Exception {
        UserEntity byUsername = userRepository.findByUsername(msg.getUsername());

        if (byUsername == null) {
            ctx.writeAndFlush(ResponseLoginProtocolPacket.fail("用户不存在"));
            return;
        }

        if (!Objects.equals(byUsername.getPassword(),msg.getPassword())){
            ctx.writeAndFlush(ResponseLoginProtocolPacket.fail("密码不正确"));
            return;
        }

        ctx.writeAndFlush(ResponseLoginProtocolPacket.success());

        ctx.channel().attr(SessionAttributeKey.AUTH).set(true);
    }
}
