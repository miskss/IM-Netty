package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author peter
 * date: 2019-11-04 13:41
 **/

@EqualsAndHashCode(callSuper = true)
@Data(staticConstructor = "of")
public class FriendsProtocolPacket extends ProtocolPacket {
    @Override
    protected int command() {
        return CommandEnum.FRIENDS.getCommand();
    }
}
