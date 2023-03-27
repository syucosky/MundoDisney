package com.MundoDisney.api.service.imp;

import com.MundoDisney.api.dto.GenderDTO;
import com.MundoDisney.api.entity.GenderEntity;
import com.MundoDisney.api.mapper.GenderMapper;
import com.MundoDisney.api.repository.GenderRepository;
import com.MundoDisney.api.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenderServiceImp implements GenderService {

    @Autowired
    GenderRepository genderRepository;
    @Autowired
    GenderMapper genderMapper;
    @Override
    public GenderDTO save(GenderDTO dto) {
        GenderEntity entity = genderMapper.genderDto2entity(dto);
        GenderEntity entitySaved = genderRepository.save(entity);

        return genderMapper.genderEntity2Dto(entitySaved);
    }
    public GenderDTO findById(Long id){
        GenderEntity entity = genderRepository.getOneForId(id);
        GenderDTO dto = genderMapper.genderEntity2Dto(entity);

        return dto;
    }
}
