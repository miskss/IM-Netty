package com.example.imnetty.protocol.server;

import com.example.imnetty.model.UserVO;
import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

import java.util.List;

/**
 * @author peter
 * date: 2019-11-04 13:47
 **/
@Data
public class ResponseFriendsProtocolPacket extends ProtocolPacket {

    private List<UserVO> users;


    @Override
    protected int command() {
        return CommandEnum.RESPONSE_FRIEND.getCommand();
    }


    public static ResponseFriendsProtocolPacket of(List<UserVO> users) {
        ResponseFriendsProtocolPacket packet = new ResponseFriendsProtocolPacket();
        packet.setUsers(users);
        return packet;
    }
}
