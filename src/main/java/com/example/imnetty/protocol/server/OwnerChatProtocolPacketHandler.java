package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import com.example.imnetty.model.GroupChat;
import com.example.imnetty.model.GroupChatVO;
import com.example.imnetty.protocol.client.OwnerChatProtocolPacket;
import com.example.imnetty.repository.GroupChatRepository;
import com.example.imnetty.repository.impl.GroupChatRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author peter
 * date: 2019-11-06 10:17
 **/
public class OwnerChatProtocolPacketHandler extends SimpleChannelInboundHandler<OwnerChatProtocolPacket> {
    private GroupChatRepository chatRepository = GroupChatRepositoryImpl.INSTANCE;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, OwnerChatProtocolPacket msg) throws Exception {
        List<GroupChat> repository = chatRepository.findByUserId(ctx.channel().attr(SessionAttributeKey.UID).get());

        List<GroupChatVO> collect = repository.stream().map(GroupChatVO::fromEntity).collect(Collectors.toList());

        ctx.writeAndFlush(ResponseOwnerChatProtocolPacket.of(collect));


    }
}
