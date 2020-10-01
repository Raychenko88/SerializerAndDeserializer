package org.example.sevice;

import org.example.model.News;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SerializerAndDeserializerTest {

    private final News news = News.builder()
            .id(1)
            .image("image")
            .heading("head")
            .text("text")
            .author("author")
            .build();

    @Test
    void serialize() {
        List<String> listPhotos = new ArrayList<>();
        Collections.addAll(listPhotos, "photo1", "photo2");
        List<String> listVideo = new ArrayList<>();
        Collections.addAll(listVideo, "video1", "video2");
        news.setListPhotos(listPhotos);
        news.setListVideo(listVideo);
        SerializerAndDeserializer<News> stringSerializerAndDeserializer = new SerializerAndDeserializer<News>() {};
        byte[] arr = stringSerializerAndDeserializer.serialize(news);
        assertTrue(arr.length > 0);
    }

    @Test
    void deserialize() {
        List<String> listPhotos = new ArrayList<>();
        Collections.addAll(listPhotos, "photo1", "photo2");
        List<String> listVideo = new ArrayList<>();
        Collections.addAll(listVideo, "video1", "video2");
        news.setListPhotos(listPhotos);
        news.setListVideo(listVideo);
        SerializerAndDeserializer<News> stringSerializerAndDeserializer = new SerializerAndDeserializer<News>() {};
        byte[] arr = stringSerializerAndDeserializer.serialize(news);
        assertNotNull(arr);
        assertEquals(news, stringSerializerAndDeserializer.deserialize(arr));
    }
}