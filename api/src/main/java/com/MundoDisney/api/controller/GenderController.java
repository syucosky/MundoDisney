package com.MundoDisney.api.controller;

import com.MundoDisney.api.dto.GenderDTO;
import com.MundoDisney.api.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class GenderController {

    @Autowired
    private GenderService genderService;


    @PostMapping("/create_gender")
    public ResponseEntity<GenderDTO> save(@RequestBody GenderDTO genderDto){
        GenderDTO genderCreated = genderService.save(genderDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(genderCreated);
    }
}
