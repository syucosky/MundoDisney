package com.MundoDisney.api.service.imp;

import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.entity.CharacterEntity;
import com.MundoDisney.api.mapper.CharacterMapper;
import com.MundoDisney.api.repository.CharacterRepository;
import com.MundoDisney.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImp implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    CharacterMapper characterMapper;

    @Override
    public CharacterDTO save(CharacterDTO dto){
        CharacterEntity entity = characterMapper.characterDto2Entity(dto);
        CharacterEntity entitySaved = characterRepository.save(entity);
        return characterMapper.characterEntity2Dto(entitySaved);
    }

    @Override
    public List<CharacterDTO> getAllCharacters(){
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterDTO> listDto = characterMapper.characterEntityList2DtoList(entities);
        return listDto;
    }
}
