package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;

/**
 * @author peter
 * date: 2019-11-05 08:57
 **/
@Data
public class CreateGroupProtocolPacket extends ProtocolPacket {

    private String groupName;

    @Override
    protected int command() {
        return CommandEnum.GROUP.getCommand();
    }


    public static CreateGroupProtocolPacket of(String groupName) {
        CreateGroupProtocolPacket packet = new CreateGroupProtocolPacket();
        packet.setGroupName(groupName);

        return packet;
    }
}
