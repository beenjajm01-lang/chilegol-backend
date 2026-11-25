package com.chilegol.chilegol.controller;

import com.chilegol.chilegol.model.Venta;
import com.chilegol.chilegol.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
@CrossOrigin(origins = "*")
@Tag(name = "Ventas", description = "Gestión de órdenes de compra y descuento de stock")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    @Operation(summary = "Listar todas las ventas")
    public ResponseEntity<List<Venta>> listarTodas() {
        return ResponseEntity.ok(ventaService.listarTodas());
    }

    @GetMapping("/usuario/{idUsuario}")
    @Operation(summary = "Listar historial de compras de un usuario")
    public ResponseEntity<List<Venta>> listarPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(ventaService.listarPorUsuario(idUsuario));
    }

    @PostMapping
    @Operation(summary = "Registrar una nueva venta")
    public ResponseEntity<?> registrarVenta(@RequestBody Venta venta) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.registrarVenta(venta));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}