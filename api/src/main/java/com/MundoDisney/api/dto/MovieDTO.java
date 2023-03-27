package com.MundoDisney.api.dto;


import com.MundoDisney.api.entity.CharacterEntity;
import com.MundoDisney.api.entity.GenderEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class MovieDTO {
    private Long id;

    private String title;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    private String image;
    private int qualification;
    private GenderDTO gender;
    private Long genderId;
    private List<CharacterDTO> characters = new ArrayList<>();

}
