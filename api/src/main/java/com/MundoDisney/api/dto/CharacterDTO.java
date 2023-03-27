package com.MundoDisney.api.dto;

import com.MundoDisney.api.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CharacterDTO {
    private Long id;
    private String name;
    private int age;
    private double weight;
    private String history;
    private String image;
    private List<MovieEntity> movies = new ArrayList<>();
}
