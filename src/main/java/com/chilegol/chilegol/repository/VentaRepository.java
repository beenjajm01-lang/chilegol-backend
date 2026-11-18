package com.chilegol.chilegol.repository;

import java.util.List;

import com.chilegol.chilegol.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findByUsuarioIdUsuario(Long idUsuario);
}