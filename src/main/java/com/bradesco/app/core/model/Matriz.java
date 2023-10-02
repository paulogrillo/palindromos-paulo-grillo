package com.bradesco.app.core.model;


import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Matriz {

    private String matrizId;
    private List<List<String>> matriz;

}
