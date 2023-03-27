package com.MundoDisney.api.controller;

import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping("/list")
    public ResponseEntity<List<CharacterDTO>> getAllCharacters(){
        List<CharacterDTO> listCharacterDTO = characterService.getAllCharacters();
        return ResponseEntity.ok().body(listCharacterDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<CharacterDTO> save(@RequestBody CharacterDTO character) {
        CharacterDTO characterCreated = characterService.save(character);

        return ResponseEntity.status(HttpStatus.CREATED).body(characterCreated); // return http status 201 CREATED and Character from bbdd
    }
}