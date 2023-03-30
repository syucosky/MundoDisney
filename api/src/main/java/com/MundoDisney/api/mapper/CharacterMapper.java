package com.MundoDisney.api.mapper;

import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.entity.CharacterEntity;
import com.MundoDisney.api.entity.MovieEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CharacterMapper {

    public CharacterEntity characterDto2Entity(CharacterDTO dto, boolean ok){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());
        characterEntity.setImage(dto.getImage());
        if(ok){
            characterEntity.setMovies(dto.getMovies());
            ok = false;
        }
        return characterEntity;
    }
    public CharacterDTO characterEntity2Dto(CharacterEntity entity, boolean ok){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setCharacterId(entity.getCharacterId());
        characterDTO.setName(entity.getName());
        characterDTO.setAge(entity.getAge());
        characterDTO.setWeight(entity.getWeight());
        characterDTO.setHistory(entity.getHistory());
        characterDTO.setImage(entity.getImage());
        if(ok){
            characterDTO.setMovies(entity.getMovies());
            ok = false;
        }
        return characterDTO;
    }

    public List<CharacterDTO> characterEntityList2DtoList(List<CharacterEntity> entities){
        List<CharacterDTO> listDto = new ArrayList<>();
        for (CharacterEntity item: entities) {
            listDto.add(characterEntity2Dto(item,true));
        }
        return listDto;
    }
    public List<CharacterEntity> characterDTOlist2EntityList(List<CharacterDTO> dtos){
        List<CharacterEntity> entities = new ArrayList<>();
        for (CharacterDTO item: dtos) {
            entities.add(this.characterDto2Entity(item,true));
        }
        return entities;
    }
    public Set<CharacterDTO> setEntity2SetDto(Set<CharacterEntity> setEntity){
        Set<CharacterDTO> setDto = new HashSet<>();
        for (CharacterEntity item:setEntity) {
            setDto.add(characterEntity2Dto(item,false));
        }

        return setDto;
    }
    public Set<CharacterEntity> setDto2SetEntity(Set<CharacterDTO> setDto){
        Set<CharacterEntity> setEntity = new HashSet<>();
        for (CharacterDTO item:setDto) {
            setEntity.add(characterDto2Entity(item,true));
        }

        return setEntity;
    }
    public CharacterEntity entityModfied(CharacterEntity entityFromBD, CharacterDTO dto){
        if(!dto.getName().isEmpty()){
            entityFromBD.setName(dto.getName());
        }
        if(dto.getImage() != null){
            entityFromBD.setImage(dto.getImage());
        }
        if (dto.getAge() != null) {
            entityFromBD.setAge(dto.getAge());
        }
        if(dto.getWeight() != null){
            entityFromBD.setWeight(dto.getWeight());
        }
        if(!dto.getHistory().isEmpty()){
            entityFromBD.setHistory(dto.getHistory());
        }
        return entityFromBD;
    }
}
