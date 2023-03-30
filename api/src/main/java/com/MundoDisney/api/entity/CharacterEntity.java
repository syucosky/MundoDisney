package com.MundoDisney.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "characters")
public class CharacterEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long characterId;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    private String image;


    @JsonIgnore
    @ManyToMany(mappedBy = "characters", cascade = CascadeType.ALL)
    private Set<MovieEntity> movies = new HashSet<>();
 }
