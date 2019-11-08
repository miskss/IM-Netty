package com.example.imnetty.protocol.server;

import com.example.imnetty.model.GroupChat;
import com.example.imnetty.model.GroupChatVO;
import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author peter
 * date: 2019-11-06 10:21
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseOwnerChatProtocolPacket extends ProtocolPacket {

    private List<GroupChatVO> chats;

    @Override
    protected int command() {
        return CommandEnum.RESPONSE_OWNER_CHAT.getCommand();
    }


    public static ResponseOwnerChatProtocolPacket of(List<GroupChatVO> chats) {
        ResponseOwnerChatProtocolPacket packet = new ResponseOwnerChatProtocolPacket();

        packet.setChats(chats);

        return packet;
    }
}
