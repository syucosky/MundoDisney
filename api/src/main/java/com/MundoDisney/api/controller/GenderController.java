package com.MundoDisney.api.controller;

import com.MundoDisney.api.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GenderController {


    @Autowired
    GenderService genderService;
}
