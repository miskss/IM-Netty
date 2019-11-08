package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import com.example.imnetty.model.GroupChat;
import com.example.imnetty.model.UserEntity;
import com.example.imnetty.protocol.client.AddGroupChatProtocolPacket;
import com.example.imnetty.repository.GroupChatRepository;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.impl.GroupChatRepositoryImpl;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author peter
 * date: 2019-11-06 10:52
 **/
public class AddGroupChatProtocolPacketHandler extends SimpleChannelInboundHandler<AddGroupChatProtocolPacket> {
    private GroupChatRepository groupChatRepository = GroupChatRepositoryImpl.INSTANCE;
    private UserRepository repository = UserRepositoryImpl.INSTANCE;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, AddGroupChatProtocolPacket msg) throws Exception {
        String groupId = msg.getGroupId();

        String uid = ctx.channel().attr(SessionAttributeKey.UID).get();
        GroupChat groupChat = groupChatRepository.findByChatId(groupId);
        if(groupChat == null) return;

        UserEntity byUserId = repository.findByUserId(uid);

        groupChat.addMember(byUserId);

        groupChatRepository.save(groupChat);

        groupChatRepository.saveUserChatRelation(uid,groupId);
    }
}
