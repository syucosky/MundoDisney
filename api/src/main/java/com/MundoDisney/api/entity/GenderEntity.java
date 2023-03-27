package com.MundoDisney.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "gender")
public class GenderEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String image;

    @OneToMany(mappedBy = "gender")
    private List<MovieEntity> movies;
}
