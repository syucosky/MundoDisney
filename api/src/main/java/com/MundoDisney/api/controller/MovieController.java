package com.MundoDisney.api.controller;

import com.MundoDisney.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MovieController {

    @Autowired
    MovieService movieService;
}
