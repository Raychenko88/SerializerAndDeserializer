package org.example.sevice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public abstract class SerializerAndDeserializer<T> {

    private Class<T> persistentClass;

    public SerializerAndDeserializer() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public byte[] serialize(T object) {
        String jsonStr = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            jsonStr = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonStr.getBytes();
    }

    public T deserialize(byte[] arr){
        T object = null;
        String stringBytes = null;
        try {
            stringBytes = new String (arr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
             object = new ObjectMapper().readValue(stringBytes, persistentClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}
