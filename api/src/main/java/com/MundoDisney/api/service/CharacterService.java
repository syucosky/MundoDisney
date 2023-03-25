package com.MundoDisney.api.service;

import com.MundoDisney.api.dto.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService{

    @Autowired
    CharacterService characterService;
    public CharacterDTO save(CharacterDTO dto){
        // TODO: Save Character
        System.out.println("Character SAVED");
        return dto;
    }

}
