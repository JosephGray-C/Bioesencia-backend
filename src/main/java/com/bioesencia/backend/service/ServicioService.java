package com.bioesencia.backend.service;

import com.bioesencia.backend.model.Servicio;
import com.bioesencia.backend.repository.ServicioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public Servicio save(@Valid Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    public boolean deleteById(Long id) {
        if (servicioRepository.existsById(id)) {
            servicioRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public Optional<Servicio> findById(Long id) {
        return servicioRepository.findById(id);
    }
}
