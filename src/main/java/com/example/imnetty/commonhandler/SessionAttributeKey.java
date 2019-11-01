package com.example.imnetty.commonhandler;

import io.netty.util.AttributeKey;

/**
 * @author peter
 * date: 2019-11-01 16:43
 **/
public interface SessionAttributeKey {

    AttributeKey<Boolean> AUTH = AttributeKey.valueOf("auth");
}
