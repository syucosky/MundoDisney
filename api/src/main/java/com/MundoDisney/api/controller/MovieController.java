package com.MundoDisney.api.controller;

import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.dto.MovieDTO;
import com.MundoDisney.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/create")
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO movie){
        MovieDTO movieCreated = movieService.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED).body(movieCreated);
    }
    @GetMapping("/list")
    public ResponseEntity<List<MovieDTO>> getListMovies(){
        List<MovieDTO> listMovies = movieService.getAllMovies();

        return ResponseEntity.ok().body(listMovies);
    }
    @PutMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<MovieDTO> assignMovieToCharacter(@PathVariable("idCharacter") Long idcharacter,
                                                           @PathVariable("idMovie") Long idmovie){
        MovieDTO characterAdded = movieService.assignCharacterToMovie(idcharacter,idmovie);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(characterAdded);
    }
}
