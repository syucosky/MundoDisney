package com.MundoDisney.api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDTO {
    private int id;
    private String name;
    private int age;
    private double weight;
    private String history;
    private byte[] image;
}
