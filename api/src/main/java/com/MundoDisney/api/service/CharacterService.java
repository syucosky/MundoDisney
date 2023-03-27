package com.MundoDisney.api.service;

import com.MundoDisney.api.dto.CharacterDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO save(CharacterDTO dto);

    List<CharacterDTO> getAllCharacters();
}
