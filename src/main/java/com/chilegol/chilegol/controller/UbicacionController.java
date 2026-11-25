package com.chilegol.chilegol.controller;

import com.chilegol.chilegol.model.Comuna;
import com.chilegol.chilegol.model.Region;
import com.chilegol.chilegol.model.Rol;
import com.chilegol.chilegol.service.RolService;
import com.chilegol.chilegol.service.UbicacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ubicaciones")
@CrossOrigin(origins = "*")
@Tag(name = "Ubicaciones y Roles", description = "Regiones, comunas y roles del sistema")
public class UbicacionController {

    @Autowired
    private UbicacionService ubicacionService;

    @Autowired
    private RolService rolService;

    @GetMapping("/regiones")
    @Operation(summary = "Listar todas las regiones")
    public ResponseEntity<List<Region>> listarRegiones() {
        return ResponseEntity.ok(ubicacionService.listarRegiones());
    }

    @GetMapping("/regiones/{idRegion}/comunas")
    @Operation(summary = "Listar comunas de una región")
    public ResponseEntity<List<Comuna>> listarComunas(@PathVariable Long idRegion) {
        return ResponseEntity.ok(ubicacionService.listarComunasPorRegion(idRegion));
    }

    @GetMapping("/roles")
    @Operation(summary = "Listar roles disponibles")
    public ResponseEntity<List<Rol>> listarRoles() {
        return ResponseEntity.ok(rolService.listarTodos());
    }
}
