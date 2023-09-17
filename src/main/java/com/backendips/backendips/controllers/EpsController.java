package com.backendips.backendips.controllers;


import com.backendips.backendips.models.Eps;
import com.backendips.backendips.services.EpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/eps")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class EpsController {

    @Autowired
    private EpsService epsService;

    @GetMapping
    public ResponseEntity<List<Eps>> getAllEps(){
        List<Eps> eps = epsService.getAllEps();
        if(eps.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(eps);
    }
}
