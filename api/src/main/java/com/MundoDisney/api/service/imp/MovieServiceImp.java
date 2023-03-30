package com.MundoDisney.api.service.imp;


import com.MundoDisney.api.dto.CharacterDTO;
import com.MundoDisney.api.dto.MovieDTO;
import com.MundoDisney.api.entity.CharacterEntity;
import com.MundoDisney.api.entity.MovieEntity;
import com.MundoDisney.api.mapper.GenderMapper;
import com.MundoDisney.api.mapper.MovieMapper;
import com.MundoDisney.api.repository.CharacterRepository;
import com.MundoDisney.api.repository.GenderRepository;
import com.MundoDisney.api.repository.MovieRepository;
import com.MundoDisney.api.service.GenderService;
import com.MundoDisney.api.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MovieServiceImp implements MovieService {

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    GenderRepository genderRepository;
    @Autowired
    MovieMapper movieMapper;
    @Autowired
    GenderMapper genderMapper;
    @Override
    public MovieDTO save(MovieDTO movieDto) {
        MovieEntity entity = movieMapper.movieDto2Entity(movieDto,true);
        entity.setGender(genderRepository.getOneForId(entity.getGenderId()));
        MovieEntity entitySaved = movieRepository.save(entity);
        return movieMapper.movieEntity2Dto(entitySaved,true);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> entityMovieList = movieRepository.findAll();
        List<MovieDTO> dtoMovieList = movieMapper.movieEntityList2DtoList(entityMovieList);
        return dtoMovieList;
    }
    @Override
    public MovieDTO assignCharacterToMovie(Long idCharacter, Long idMovie) {
        Set<CharacterEntity> characters = null;
        MovieEntity entityMovie = movieRepository.findById(idMovie).get();
        CharacterEntity entityCharacter = characterRepository.findById(idCharacter).get();
        characters = entityMovie.getCharacters();
        characters.add(entityCharacter);
        entityMovie.setCharacters(characters);
        movieRepository.save(entityMovie);
        MovieDTO dto = movieMapper.movieEntity2Dto(entityMovie,true);
        return dto;
    }


}
