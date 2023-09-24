package com.backendips.backendips.services;

import com.backendips.backendips.models.EstadoCita;
import com.backendips.backendips.repositories.EstadoCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoCitaService {

    @Autowired
    private EstadoCitaRepository estadoCitaRepository;

    public List<EstadoCita>getAllEstadosCitas(){
        return estadoCitaRepository.findAll();
    }
}
