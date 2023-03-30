package com.MundoDisney.api.mapper;

import com.MundoDisney.api.dto.GenderDTO;
import com.MundoDisney.api.entity.GenderEntity;
import org.springframework.stereotype.Component;

@Component
public class GenderMapper {

    public GenderEntity genderDto2entity(GenderDTO dto){
        GenderEntity entity = new GenderEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());

        return entity;
    }

    public GenderDTO genderEntity2Dto(GenderEntity entity){
        GenderDTO dto = new GenderDTO();
        dto.setGenderId(entity.getGenderId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());

        return dto;
    }
}