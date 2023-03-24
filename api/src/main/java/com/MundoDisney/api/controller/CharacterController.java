package com.MundoDisney.api.controller;

import com.MundoDisney.api.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CharacterController {

    @Autowired
    CharacterService characterService;
}
