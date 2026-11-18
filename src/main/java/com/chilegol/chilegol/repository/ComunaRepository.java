package com.chilegol.chilegol.repository;

import java.util.List;

import com.chilegol.chilegol.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunaRepository extends JpaRepository<Comuna, Long> {
    List<Comuna> findByRegionIdRegion(Long idRegion);
}