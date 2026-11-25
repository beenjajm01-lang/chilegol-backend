package com.chilegol.chilegol.service;

import com.chilegol.chilegol.model.*;
import com.chilegol.chilegol.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private MetodoEnvioRepository metodoEnvioRepository;

    public List<Venta> listarTodas() {
        return ventaRepository.findAll();
    }

    public List<Venta> listarPorUsuario(Long idUsuario) {
        return ventaRepository.findByUsuarioIdUsuario(idUsuario);
    }

    @Transactional
    public Venta registrarVenta(Venta venta) {
        int subtotalProductos = 0;

        for (DetalleVenta detalle : venta.getDetalles()) {
            Producto producto = productoRepository.findById(detalle.getProducto().getIdProducto())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (producto.getStock() < detalle.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombre());
            }

            producto.setStock(producto.getStock() - detalle.getCantidad());
            productoRepository.save(producto);

            detalle.setPrecioUnitario(producto.getPrecio());
            detalle.setVenta(venta);
            subtotalProductos += producto.getPrecio() * detalle.getCantidad();
        }

        MetodoEnvio envio = metodoEnvioRepository.findById(venta.getMetodoEnvio().getIdMetodoEnvio())
                .orElseThrow(() -> new RuntimeException("Método de envío no válido"));

        venta.setTotal(subtotalProductos + envio.getCosto());
        return ventaRepository.save(venta);
    }
}
