package com.chilegol.chilegol.service;

import com.chilegol.chilegol.model.Imagen;
import com.chilegol.chilegol.model.Producto;
import com.chilegol.chilegol.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
    }

    public List<Producto> listarPorCategoria(Long idCategoria) {
        return productoRepository.findByCategoriaIdCategoria(idCategoria);
    }

    public List<Producto> listarPorEquipo(Long idEquipo) {
        return productoRepository.findByEquipoIdEquipo(idEquipo);
    }

    public Producto guardar(Producto producto) {
        if (producto.getImagenes() != null) {
            for (Imagen img : producto.getImagenes()) {
                img.setProducto(producto);
            }
        }
        return productoRepository.save(producto);
    }

    public Producto actualizar(Long id, Producto datos) {
        Producto existente = obtenerPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setPrecio(datos.getPrecio());
        existente.setStock(datos.getStock());
        existente.setCategoria(datos.getCategoria());
        existente.setEquipo(datos.getEquipo());

        if (datos.getImagenes() != null) {
            existente.getImagenes().clear();
            for (Imagen img : datos.getImagenes()) {
                img.setProducto(existente);
                existente.getImagenes().add(img);
            }
        }
        return productoRepository.save(existente);
    }

    public void eliminar(Long id) {
        Producto existente = obtenerPorId(id);
        productoRepository.delete(existente);
    }
}
