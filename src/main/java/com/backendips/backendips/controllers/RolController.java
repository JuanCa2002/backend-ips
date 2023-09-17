package com.backendips.backendips.controllers;

import com.backendips.backendips.models.Rol;
import com.backendips.backendips.services.RolService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rol")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles(){
        List<Rol> roles = rolService.getAllRoles();
        if(roles.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(roles);
        }
    }
}
