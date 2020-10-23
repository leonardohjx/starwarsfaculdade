package com.example.retrofit2.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class People {
    private Integer height;
    private Integer mass;

    private String name;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String films;
    private String species;
    private String vehicles;
    private String starships;
    private String created;
    private String edited;
    private String url;

}
