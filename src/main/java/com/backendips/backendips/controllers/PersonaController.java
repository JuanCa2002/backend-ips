package com.backendips.backendips.controllers;

import com.backendips.backendips.DTO.ChangePasswordDTO;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/persona")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @GetMapping("/{numberDocument}")
    public ResponseEntity<Persona> getByNumberDocument(@PathVariable String numberDocument) {
        Persona persona = personaService.getByDocument(numberDocument);
        if (persona == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(persona);
    }

    @PutMapping
    public ResponseEntity<Persona> update(@RequestBody Persona persona) {
        if (persona == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(personaService.put(persona));
        }
    }

    @PutMapping("/changePassword/{numberDocument}")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO, @PathVariable String numberDocument) {
        if (changePasswordDTO == null) {
            return ResponseEntity.badRequest().body("{\"message\": \"Petición incorrecta\"}");
        } else {
            String currentPassword = changePasswordDTO.getCurrentPassword();
            String newPassword = changePasswordDTO.getNewPassword();

            boolean resultado = personaService.putPassword(numberDocument, currentPassword, newPassword);
            if (resultado) {
                return ResponseEntity.ok("{\"message\": \"Contraseña cambiada con éxito\"}");
            }
            return ResponseEntity.badRequest().body("{\"message\": \"Contraseña incorrecta\"}");
        }
    }
}
