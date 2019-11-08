package com.example.imnetty.protocol.server;

import com.example.imnetty.model.GroupChat;
import com.example.imnetty.model.GroupChatVO;
import com.example.imnetty.protocol.client.SearchGroupChatProtocolPacket;
import com.example.imnetty.repository.GroupChatRepository;
import com.example.imnetty.repository.impl.GroupChatRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author peter
 * date: 2019-11-05 16:25
 **/
public class SearchGroupChatProtocolPacketHandler extends SimpleChannelInboundHandler<SearchGroupChatProtocolPacket> {
    private GroupChatRepository groupChatRepository = GroupChatRepositoryImpl.INSTANCE;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, SearchGroupChatProtocolPacket msg) throws Exception {
        String groupId = msg.getGroupId();

        GroupChat byChatId = groupChatRepository.findByChatId(groupId);

        ctx.writeAndFlush(ResponseSearchGroupChatProtocolPacket.of(byChatId == null ? null : GroupChatVO.fromEntity(byChatId)));


    }
}
