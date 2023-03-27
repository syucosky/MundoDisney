package com.MundoDisney.api.service;


import com.MundoDisney.api.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {

    MovieDTO save(MovieDTO movieDto);

    List<MovieDTO> getAllMovies();
}
