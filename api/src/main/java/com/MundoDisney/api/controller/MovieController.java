package com.MundoDisney.api.controller;

import com.MundoDisney.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
}
