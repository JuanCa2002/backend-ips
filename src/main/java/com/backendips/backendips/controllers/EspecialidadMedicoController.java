package com.backendips.backendips.controllers;

import com.backendips.backendips.models.EspecialidadMedico;
import com.backendips.backendips.services.EspecialidadMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/especialidad")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EspecialidadMedicoController {

    @Autowired
    private EspecialidadMedicoService especialidadMedicoService;

    @GetMapping
    public ResponseEntity<List<EspecialidadMedico>> getAllEspecialidades(){
        List<EspecialidadMedico> especialidadesMedicos = especialidadMedicoService.getAllEspecialidades();
        if(especialidadesMedicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(especialidadesMedicos);
    }
}
