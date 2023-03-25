package com.MundoDisney.api.service;

import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService{

    public CharacterDTO save(CharacterDTO dto){
        // TODO: Save Character
        System.out.println("Character SAVED");
        return dto;
    }

}
