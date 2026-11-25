package com.chilegol.chilegol.repository;

import com.chilegol.chilegol.model.MetodoEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoEnvioRepository extends JpaRepository<MetodoEnvio, Long> {
}