package com.chilegol.chilegol.repository;

import com.chilegol.chilegol.model.Comuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComunaRepository extends JpaRepository<Comuna, Long> {
    List<Comuna> findByRegionIdRegion(Long idRegion);
}