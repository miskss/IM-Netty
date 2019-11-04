package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import com.example.imnetty.model.UserEntity;
import com.example.imnetty.model.UserVO;
import com.example.imnetty.protocol.client.FriendsProtocolPacket;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author peter
 * date: 2019-11-04 13:50
 **/
public class FriendsProtocolPacketHandler extends SimpleChannelInboundHandler<FriendsProtocolPacket> {

    private UserRepository userRepository = UserRepositoryImpl.INSTANCE;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FriendsProtocolPacket msg) throws Exception {
        String uid = ctx.channel().attr(SessionAttributeKey.UID).get();

        List<UserVO> vos = userRepository.findUserFriends(uid)
                .stream().map(UserEntity::convertTo)
                .collect(Collectors.toList());

        ResponseFriendsProtocolPacket packet = ResponseFriendsProtocolPacket.of(vos);

        ctx.writeAndFlush(packet);


    }
}
