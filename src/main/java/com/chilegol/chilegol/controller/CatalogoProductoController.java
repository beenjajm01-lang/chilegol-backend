package com.chilegol.chilegol.controller;

import com.chilegol.chilegol.model.Categoria;
import com.chilegol.chilegol.model.Equipo;
import com.chilegol.chilegol.service.CategoriaService;
import com.chilegol.chilegol.service.EquipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/catalogos")
@CrossOrigin(origins = "*")
@Tag(name = "Catálogos de Producto", description = "Categorías y equipos disponibles")
public class CatalogoProductoController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private EquipoService equipoService;

    @GetMapping("/categorias")
    @Operation(summary = "Listar todas las categorías")
    public ResponseEntity<List<Categoria>> listarCategorias() {
        return ResponseEntity.ok(categoriaService.listarTodas());
    }

    @GetMapping("/equipos")
    @Operation(summary = "Listar todos los equipos")
    public ResponseEntity<List<Equipo>> listarEquipos() {
        return ResponseEntity.ok(equipoService.listarTodos());
    }
}

