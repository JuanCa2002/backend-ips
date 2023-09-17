package com.backendips.backendips.controllers;

import com.backendips.backendips.models.TipoIdentificacion;
import com.backendips.backendips.services.TipoIdentificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipo-identificacion")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TipoIdentificacionController {

    @Autowired
    private TipoIdentificacionService tipoIdentificacionService;

    @GetMapping
    public ResponseEntity<List<TipoIdentificacion>> getAllTipoIdentificacion(){
        List<TipoIdentificacion> tiposIdentificacion = tipoIdentificacionService.getAllTipoIdentificacion();
        if(tiposIdentificacion.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tiposIdentificacion);
    }
}
