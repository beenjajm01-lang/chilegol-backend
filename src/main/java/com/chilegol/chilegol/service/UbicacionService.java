package com.chilegol.chilegol.service;

import com.chilegol.chilegol.model.Comuna;
import com.chilegol.chilegol.model.Region;
import com.chilegol.chilegol.repository.ComunaRepository;
import com.chilegol.chilegol.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UbicacionService {
    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private ComunaRepository comunaRepository;

    public List<Region> listarRegiones() {
        return regionRepository.findAll();
    }

    public List<Comuna> listarComunasPorRegion(Long idRegion) {
        return comunaRepository.findByRegionIdRegion(idRegion);
    }
}