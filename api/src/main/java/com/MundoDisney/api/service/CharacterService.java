package com.MundoDisney.api.service;

import com.MundoDisney.api.dto.CharacterDTO;

import java.util.List;
import java.util.Set;

public interface CharacterService {

    CharacterDTO save(CharacterDTO dto);

    List<CharacterDTO> getAllCharacters();

    CharacterDTO editForId(CharacterDTO dto, Long id);

}
