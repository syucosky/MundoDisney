package com.MundoDisney.api.service.imp;


import com.MundoDisney.api.dto.MovieDTO;
import com.MundoDisney.api.entity.MovieEntity;
import com.MundoDisney.api.mapper.GenderMapper;
import com.MundoDisney.api.mapper.MovieMapper;
import com.MundoDisney.api.repository.GenderRepository;
import com.MundoDisney.api.repository.MovieRepository;
import com.MundoDisney.api.service.GenderService;
import com.MundoDisney.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    GenderMapper genderMapper;
    @Override
    public MovieDTO save(MovieDTO movieDto) {
        MovieEntity entity = movieMapper.movieDto2Entity(movieDto);
        entity.setGender(genderRepository.getOneForId(entity.getGenderId()));
        MovieEntity entitySaved = movieRepository.save(entity);
        return movieMapper.movieEntity2Dto(entitySaved);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> entityMovieList = movieRepository.findAll();
        List<MovieDTO> dtoMovieList = movieMapper.movieEntityList2DtoList(entityMovieList);
        return dtoMovieList;
    }

}
