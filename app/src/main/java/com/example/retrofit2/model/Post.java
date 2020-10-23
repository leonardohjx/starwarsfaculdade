package com.example.retrofit2.model;

import lombok.Builder;
import lombok.Data;

/**
 * Passo 4 - Criar classe de modelo de acordo com o recurso utilizado.
 */

@Data
@Builder
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

}
