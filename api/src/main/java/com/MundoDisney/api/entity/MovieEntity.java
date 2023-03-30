package com.MundoDisney.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
@Entity
@Table(name = "movie")
public class MovieEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long movieId;
    private String title;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;
    private String image;
    private int qualification;

    @JsonIgnore
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "movie_character",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id")
    )
    private Set<CharacterEntity> characters = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id", insertable = false, updatable = false)
    private GenderEntity gender;

    @Column(name = "gender_id", nullable = false)
    private Long genderId;
}
