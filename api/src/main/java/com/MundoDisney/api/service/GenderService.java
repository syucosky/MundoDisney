package com.MundoDisney.api.service;

import com.MundoDisney.api.dto.GenderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface GenderService {

    GenderDTO save(GenderDTO dto);

    GenderDTO findById(Long id);
}
