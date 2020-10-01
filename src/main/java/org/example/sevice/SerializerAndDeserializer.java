package org.example.sevice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class SerializerAndDeserializer<T> {

    private Class<T> persistentClass;

    public SerializerAndDeserializer() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public byte[] serialize(T object) {
        try {
            return new ObjectMapper().writeValueAsString(object).getBytes();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("serialize does not work");
    }

    public T deserialize(byte[] arr) {
        String stringBytes = new String(arr, Charset.defaultCharset());
        try {
            return new ObjectMapper().readValue(stringBytes, persistentClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("deserialize does not work");
    }
}
