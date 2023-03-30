package com.MundoDisney.api.dto;

import com.MundoDisney.api.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class CharacterDTO {
    private Long characterId;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    private String image;
    private Set<MovieEntity> movies = new HashSet<>();
}
