package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import com.example.imnetty.model.GroupChat;
import com.example.imnetty.model.UserEntity;
import com.example.imnetty.protocol.client.CreateGroupProtocolPacket;
import com.example.imnetty.repository.GroupChatRepository;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.impl.GroupChatRepositoryImpl;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author peter
 * date: 2019-11-05 09:01
 **/
public class CreateGroupProtocolPacketHandler extends SimpleChannelInboundHandler<CreateGroupProtocolPacket> {

    private UserRepository userRepository = UserRepositoryImpl.INSTANCE;
    private GroupChatRepository groupChatRepository = GroupChatRepositoryImpl.INSTANCE;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupProtocolPacket msg) throws Exception {

        String uid = ctx.channel().attr(SessionAttributeKey.UID).get();

        UserEntity entity = userRepository.findByUserId(uid);

        //创建群聊
        GroupChat chat = GroupChat.create(msg.getGroupName(), entity);

        groupChatRepository.save(chat);

        //保存关联关系
        groupChatRepository.saveUserChatRelation(uid,chat.getChatId());



    }
}
