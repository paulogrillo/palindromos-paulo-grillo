package com.bradesco.app.dataprovider.gateway.database.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "word")
public class WordEntity {

    private String matrizId;
    private List<String> words;
}
