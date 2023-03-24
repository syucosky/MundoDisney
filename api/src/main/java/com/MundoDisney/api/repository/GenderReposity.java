package com.MundoDisney.api.repository;

import com.MundoDisney.api.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderReposity extends JpaRepository<Gender,Integer> {
}
