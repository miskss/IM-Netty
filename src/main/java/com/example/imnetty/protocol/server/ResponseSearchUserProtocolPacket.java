package com.example.imnetty.protocol.server;

import com.example.imnetty.model.UserEntity;
import com.example.imnetty.model.UserVO;
import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author peter
 * date: 2019-11-04 09:50
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class ResponseSearchUserProtocolPacket extends ProtocolPacket {

    private List<UserVO> users;

    @Override
    protected int command() {
        return CommandEnum.RESPONSE_SEARCH_USER.getCommand();
    }

    public static ResponseSearchUserProtocolPacket of(List<UserEntity> userEntities) {
        ResponseSearchUserProtocolPacket packet = new ResponseSearchUserProtocolPacket();
        List<UserVO> users;
        if (userEntities == null) {
            users = new ArrayList<>();
        } else {
            users = userEntities.stream().map(UserEntity::convertTo).collect(Collectors.toList());
        }
        packet.setUsers(users);
        return packet;
    }

}
