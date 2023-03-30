package com.MundoDisney.api.service.imp;

import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.entity.CharacterEntity;
import com.MundoDisney.api.entity.MovieEntity;
import com.MundoDisney.api.mapper.CharacterMapper;
import com.MundoDisney.api.repository.CharacterRepository;
import com.MundoDisney.api.repository.MovieRepository;
import com.MundoDisney.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CharacterServiceImp implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CharacterMapper characterMapper;

    @Override
    public CharacterDTO save(CharacterDTO dto){
        CharacterEntity entity = characterMapper.characterDto2Entity(dto,true);
        CharacterEntity entitySaved = characterRepository.save(entity);
        return characterMapper.characterEntity2Dto(entitySaved,true);
    }

    @Override
    public List<CharacterDTO> getAllCharacters(){
        List<CharacterDTO> listDto = characterMapper.characterEntityList2DtoList(characterRepository.findAll());
        return listDto;
    }

    @Override
    public CharacterDTO editForId(CharacterDTO dto, Long id) {
        CharacterEntity entityFromBD = characterRepository.findById(id).get();
        CharacterEntity modifiedEntity = characterMapper.entityModfied(entityFromBD,dto);
        characterRepository.save(modifiedEntity);
        CharacterDTO modifiedDto = characterMapper.characterEntity2Dto(modifiedEntity,true);
        return modifiedDto;
    }


}
