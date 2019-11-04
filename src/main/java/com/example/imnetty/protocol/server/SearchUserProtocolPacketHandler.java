package com.example.imnetty.protocol.server;

import com.example.imnetty.model.UserEntity;
import com.example.imnetty.protocol.client.SearchUserProtocolPacket;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

/**
 * @author peter
 * date: 2019-11-04 09:41
 **/
public class SearchUserProtocolPacketHandler extends SimpleChannelInboundHandler<SearchUserProtocolPacket> {
    private UserRepository userRepository = UserRepositoryImpl.INSTANCE;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SearchUserProtocolPacket msg) throws Exception {
        String search = msg.getSearch();

        List<UserEntity> byUsernameOrIdLike = userRepository.findByUsernameOrIdLike(search);

        ResponseSearchUserProtocolPacket protocolPacket = ResponseSearchUserProtocolPacket.of(byUsernameOrIdLike);

        ctx.writeAndFlush(protocolPacket);

    }
}
