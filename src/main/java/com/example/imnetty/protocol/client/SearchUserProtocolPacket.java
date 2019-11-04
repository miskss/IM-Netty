package com.example.imnetty.protocol.client;

import com.example.imnetty.protocol.ProtocolPacket;
import com.example.imnetty.protocol.command.CommandEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author peter
 * date: 2019-11-04 09:37
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchUserProtocolPacket extends ProtocolPacket {

    private String search;

    @Override
    protected int command() {
        return CommandEnum.SEARCH_USER.getCommand();
    }


    public static SearchUserProtocolPacket of(String search) {

        SearchUserProtocolPacket packet = new SearchUserProtocolPacket();
        packet.setSearch(search);

        return packet;
    }
}
