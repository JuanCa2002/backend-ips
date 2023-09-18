package com.backendips.backendips.services;


import com.backendips.backendips.models.EspecialidadMedico;
import com.backendips.backendips.repositories.EspecialidadMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadMedicoService {

    @Autowired
    private EspecialidadMedicoRepository especialidadMedicoRepository;

    public List<EspecialidadMedico> getAllEspecialidades(){
        return especialidadMedicoRepository.findAll();
    }
}
