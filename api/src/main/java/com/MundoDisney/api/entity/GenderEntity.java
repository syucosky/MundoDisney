package com.MundoDisney.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "gender")
public class GenderEntity {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long genderId;
    private String name;
    private String image;
}
