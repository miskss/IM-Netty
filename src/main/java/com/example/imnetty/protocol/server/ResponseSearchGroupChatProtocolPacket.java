package com.example.imnetty.protocol.server;

import com.example.imnetty.model.GroupChatVO;
import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-05 16:41
 **/
@Data
public class ResponseSearchGroupChatProtocolPacket extends ProtocolPacket {
    private GroupChatVO chat;

    @Override
    protected int command() {
        return CommandEnum.RESPONSE_SEARCH_GROUP.getCommand();
    }

    public static ResponseSearchGroupChatProtocolPacket of(GroupChatVO vo) {
        ResponseSearchGroupChatProtocolPacket packet = new ResponseSearchGroupChatProtocolPacket();
        packet.setChat(vo);

        return packet;
    }
}
