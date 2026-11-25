package com.chilegol.chilegol.service;

import com.chilegol.chilegol.model.Estado;
import com.chilegol.chilegol.model.MetodoEnvio;
import com.chilegol.chilegol.model.MetodoPago;
import com.chilegol.chilegol.repository.EstadoRepository;
import com.chilegol.chilegol.repository.MetodoEnvioRepository;
import com.chilegol.chilegol.repository.MetodoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoVentaService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private MetodoEnvioRepository metodoEnvioRepository;

    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    public List<MetodoEnvio> listarMetodosEnvio() {
        return metodoEnvioRepository.findAll();
    }

    public List<MetodoPago> listarMetodosPago() {
        return metodoPagoRepository.findAll();
    }
}

