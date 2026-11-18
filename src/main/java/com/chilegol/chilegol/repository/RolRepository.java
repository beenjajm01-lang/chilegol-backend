package com.chilegol.chilegol.repository;

import java.util.Optional;

import com.chilegol.chilegol.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(String nombre);
}