package com.chilegol.chilegol.repository;

import java.util.List;

import com.chilegol.chilegol.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByCategoriaIdCategoria(Long idCategoria);
    List<Producto> findByEquipoIdEquipo(Long idEquipo);
}