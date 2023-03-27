package com.MundoDisney.api.mapper;

import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.entity.CharacterEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    public CharacterEntity characterDto2Entity(CharacterDTO dto){
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());
        characterEntity.setImage(dto.getImage());

        return characterEntity;
    }
    public CharacterDTO characterEntity2Dto(CharacterEntity entity){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setId(entity.getId());
        characterDTO.setName(entity.getName());
        characterDTO.setAge(entity.getAge());
        characterDTO.setWeight(entity.getWeight());
        characterDTO.setHistory(entity.getHistory());
        characterDTO.setImage(entity.getImage());
        characterDTO.setMovies(entity.getMovies());

        return characterDTO;
    }

    public List<CharacterDTO> characterEntityList2DtoList(List<CharacterEntity> entities){
        List<CharacterDTO> listDto = new ArrayList<>();
        for (CharacterEntity item: entities) {
            listDto.add(this.characterEntity2Dto(item));
        }
        return listDto;
    }
    public List<CharacterEntity> characterDTOlist2EntityList(List<CharacterDTO> dtos){
        List<CharacterEntity> entities = new ArrayList<>();
        for (CharacterDTO item: dtos) {
            entities.add(this.characterDto2Entity(item));
        }
        return entities;
    }
}
