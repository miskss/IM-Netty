package com.example.imnetty.protocol.server;

import com.example.imnetty.model.UserEntity;
import com.example.imnetty.model.UserFactory;
import com.example.imnetty.protocol.client.RegisterProtocolPacket;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.stereotype.Component;

/**
 * @author peter
 * date: 2019-11-01 13:36
 **/
@Component
public class RegisterProtocolPacketHandler extends SimpleChannelInboundHandler<RegisterProtocolPacket> {

    private UserRepository userRepository = UserRepositoryImpl.INSTANCE;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RegisterProtocolPacket msg) throws Exception {

        UserEntity byUsername = userRepository.findByUsername(msg.getUsername());

        if (byUsername != null) {
            ctx.writeAndFlush(ResponseRegisterProtocolPacket.fail("用户名已被注册"));
            return;
        }

        UserEntity userEntity = UserFactory.createUser(msg.getUsername(), msg.getPassword());

        userRepository.save(userEntity);

        ctx.writeAndFlush(ResponseRegisterProtocolPacket.success(userEntity.getUid()));

    }
}
