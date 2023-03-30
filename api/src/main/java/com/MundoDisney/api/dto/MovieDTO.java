package com.MundoDisney.api.dto;


import com.MundoDisney.api.entity.CharacterEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class MovieDTO {
    private Long movieId;

    private String title;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    private String image;
    private int qualification;
    private GenderDTO gender;
    private Long genderId;
    private Set<CharacterDTO> characters = new HashSet<>();

}
