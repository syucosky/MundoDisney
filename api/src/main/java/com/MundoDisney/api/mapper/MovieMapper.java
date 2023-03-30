package com.MundoDisney.api.mapper;


import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.dto.MovieDTO;
import com.MundoDisney.api.entity.CharacterEntity;
import com.MundoDisney.api.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {
    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    GenderMapper genderMapper;
    public MovieEntity movieDto2Entity(MovieDTO dto, boolean ok){
        MovieEntity entity = new MovieEntity();
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        entity.setCreationDate(dto.getCreationDate());
        entity.setQualification(dto.getQualification());
        entity.setGenderId(dto.getGenderId());
        if(ok){
            entity.setCharacters(characterMapper.setDto2SetEntity(dto.getCharacters()));
            ok = false;
        }

        return entity;
    }
    public MovieDTO movieEntity2Dto(MovieEntity entity, boolean ok){
        MovieDTO dto = new MovieDTO();
        dto.setMovieId(entity.getMovieId());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setCreationDate(entity.getCreationDate());
        dto.setQualification(entity.getQualification());
        dto.setGender(genderMapper.genderEntity2Dto(entity.getGender()));
        if(ok){
            dto.setCharacters(characterMapper.setEntity2SetDto(entity.getCharacters()));
            ok = false;
        }
        return dto;
    }

    public List<MovieDTO> movieEntityList2DtoList(List<MovieEntity> ListMovieEntity){
        List<MovieDTO> listDto = new ArrayList<>();

        for (MovieEntity item: ListMovieEntity) {
            listDto.add(movieEntity2Dto(item,true));
        }
        return listDto;
    }
}
