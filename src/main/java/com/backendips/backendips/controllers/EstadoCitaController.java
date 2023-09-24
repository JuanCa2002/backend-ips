package com.backendips.backendips.controllers;

import com.backendips.backendips.models.EstadoCita;
import com.backendips.backendips.services.EstadoCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estado_cita")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EstadoCitaController {

    @Autowired
    private EstadoCitaService estadoCitaService;

    @GetMapping
    public ResponseEntity<List<EstadoCita>> getAllEstadoCita(){
        List<EstadoCita> estadoCita= estadoCitaService.getAllEstadosCitas();
        if(estadoCita.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estadoCita);
    }
}
