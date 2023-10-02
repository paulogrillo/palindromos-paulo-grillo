package com.bradesco.app.dataprovider.gateway.database.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "matriz")
public class MatrizEntity {

    private String matrizId;
    private List<List<String>> matriz;
}
