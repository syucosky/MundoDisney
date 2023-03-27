package com.MundoDisney.api.mapper;


import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.dto.MovieDTO;
import com.MundoDisney.api.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {
    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    GenderMapper genderMapper;
    public MovieEntity movieDto2Entity(MovieDTO dto){
        MovieEntity entity = new MovieEntity();
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        entity.setCreationDate(dto.getCreationDate());
        entity.setQualification(dto.getQualification());
        entity.setGenderId(dto.getGenderId());
        entity.setCharacters(characterMapper.characterDTOlist2EntityList(dto.getCharacters()));

        return entity;
    }
    public MovieDTO movieEntity2Dto(MovieEntity entity){
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setCreationDate(entity.getCreationDate());
        dto.setQualification(entity.getQualification());
        dto.setGender(genderMapper.genderEntity2Dto(entity.getGender()));
        List<CharacterDTO> charListDTO = characterMapper.characterEntityList2DtoList(entity.getCharacters());
        dto.setCharacters(charListDTO);

        return dto;
    }

    public List<MovieDTO> movieEntityList2DtoList(List<MovieEntity> listMovieEntity){
        List<MovieDTO> listDto = new ArrayList<>();

        for (MovieEntity item: listMovieEntity) {
            listDto.add(movieEntity2Dto(item));
        }
        return listDto;
    }
}
