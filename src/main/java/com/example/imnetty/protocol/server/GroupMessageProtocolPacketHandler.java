package com.example.imnetty.protocol.server;

import com.example.imnetty.commonhandler.SessionAttributeKey;
import com.example.imnetty.model.GroupChat;
import com.example.imnetty.model.UserEntity;
import com.example.imnetty.protocol.client.GroupMessageProtocolPacket;
import com.example.imnetty.repository.GroupChatRepository;
import com.example.imnetty.repository.UserRepository;
import com.example.imnetty.repository.UserSession;
import com.example.imnetty.repository.impl.GroupChatRepositoryImpl;
import com.example.imnetty.repository.impl.UserRepositoryImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author peter
 * date: 2019-11-06 10:36
 **/
public class GroupMessageProtocolPacketHandler extends SimpleChannelInboundHandler<GroupMessageProtocolPacket> {
    private GroupChatRepository chatRepository = GroupChatRepositoryImpl.INSTANCE;

    private UserRepository userRepository = UserRepositoryImpl.INSTANCE;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, GroupMessageProtocolPacket msg) throws Exception {
        String chatId = msg.getChatId();

        String message = msg.getMsg();

        GroupChat groupChat = chatRepository.findByChatId(chatId);
        if (groupChat == null) return;
        UserEntity userEntity = userRepository.findByUserId(ctx.channel().attr(SessionAttributeKey.UID).get());
        if (userEntity == null) return;

        GroupMessageToSendProtocolPacket packet = GroupMessageToSendProtocolPacket.of(chatId, groupChat.getGroupName(), userEntity.getUsername(), message);

        groupChat.getUsers().stream().map(UserEntity::getUid)
                .map(UserSession::getChannel)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet())
                .forEach(channel -> channel.writeAndFlush(packet));


    }
}
