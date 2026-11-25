package com.chilegol.chilegol.controller;

import com.chilegol.chilegol.model.Estado;
import com.chilegol.chilegol.model.MetodoEnvio;
import com.chilegol.chilegol.model.MetodoPago;
import com.chilegol.chilegol.service.CatalogoVentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas/catalogos")
@CrossOrigin(origins = "*")
@Tag(name = "Catálogos de Venta", description = "Estados de orden, métodos de envío y métodos de pago")
public class CatalogoVentaController {

    @Autowired
    private CatalogoVentaService catalogoVentaService;

    @GetMapping("/estados")
    @Operation(summary = "Listar estados de orden")
    public ResponseEntity<List<Estado>> listarEstados() {
        return ResponseEntity.ok(catalogoVentaService.listarEstados());
    }

    @GetMapping("/metodos-envio")
    @Operation(summary = "Listar métodos de envío")
    public ResponseEntity<List<MetodoEnvio>> listarMetodosEnvio() {
        return ResponseEntity.ok(catalogoVentaService.listarMetodosEnvio());
    }

    @GetMapping("/metodos-pago")
    @Operation(summary = "Listar métodos de pago")
    public ResponseEntity<List<MetodoPago>> listarMetodosPago() {
        return ResponseEntity.ok(catalogoVentaService.listarMetodosPago());
    }
}
