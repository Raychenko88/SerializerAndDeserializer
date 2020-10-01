package org.example;


import org.example.model.News;
import org.example.sevice.SerializerAndDeserializer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main( String[] args ) {
//        String str = "asddsa";
          News news = News.builder()
                .id(1)
                .image("image")
                .heading("head")
                .text("text")
                .author("author")
                .build();
        List<String> listPhotos = new ArrayList<>();
        Collections.addAll(listPhotos, "photo1", "photo2");
        List<String> listVideo = new ArrayList<>();
        Collections.addAll(listVideo, "video1", "video2");
        news.setListPhotos(listPhotos);
        news.setListVideo(listVideo);
        System.out.println(news);
        SerializerAndDeserializer<News> stringSerializerAndDeserializer = new SerializerAndDeserializer<News>() {};
        byte[] arr = stringSerializerAndDeserializer.serialize(news);
//        for (byte b : arr) {
//            System.out.println(b);
//        }
        News news1 = stringSerializerAndDeserializer.deserialize(arr);
        System.out.println(news1);
    }
}
