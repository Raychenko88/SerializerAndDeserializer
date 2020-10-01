package org.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
public class News {

    private Integer id;
    private String image;
    private List<String> listPhotos;
    private List<String> listVideo;
    private String heading;
    private String text;
    private String author;
}
