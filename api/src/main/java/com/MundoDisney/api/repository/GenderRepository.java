package com.MundoDisney.api.repository;

import com.MundoDisney.api.entity.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<GenderEntity,Long> {


    @Query("SELECT g FROM GenderEntity g WHERE g.id = :id")
    GenderEntity getOneForId(@Param("id") Long id);
}
