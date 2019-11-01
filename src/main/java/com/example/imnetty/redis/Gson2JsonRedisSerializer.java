package com.example.imnetty.redis;

import com.google.gson.Gson;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * @author peter
 * date: 2019-11-01 10:57
 **/
public class Gson2JsonRedisSerializer<T> implements RedisSerializer<T> {

    private Gson gson = new Gson();

    @Override
    public byte[] serialize(T o) throws SerializationException {
        if (o == null) return new byte[0];

        String classname = o.getClass().getName();
        String s = gson.toJson(o);
        return String.format("%s_%s", classname, s).getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {

        if (Objects.isNull(bytes) || bytes.length == 0) return null;
        String string = new String(bytes, StandardCharsets.UTF_8);

        String[] s = string.split("_");
        String classname = s[0];

        String json = s[1];
        try {
            return (T) gson.fromJson(json, Class.forName(classname));
        } catch (ClassNotFoundException e) {
            throw new SerializationException(e.getMessage(), e);
        }
    }

}
