package com.backendips.backendips.controllers;

import com.backendips.backendips.models.Persona;
import com.backendips.backendips.models.Trabajador;
import com.backendips.backendips.services.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trabajador")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class TrabajadorController {

    @Autowired
    private TrabajadorService trabajadorService;

    @PostMapping
    public ResponseEntity<String> createUsuario(@RequestBody Trabajador trabajador) {
        Trabajador newTrabajador = trabajadorService.createEncargado(trabajador);
        return ResponseEntity.ok("Encargado creado con éxito");
    }

    @GetMapping
    public ResponseEntity<List<Trabajador>> getAllUsuarios() {
        List<Trabajador> trabajadors = trabajadorService.getAllTrabajadores();
        if (trabajadors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trabajadors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> getUsuarioById(@PathVariable int id) {
        Trabajador trabajador = trabajadorService.getTrabajadorById(id);
        if (trabajador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Trabajador> deleteUsuario(@PathVariable int id) {
        Trabajador trabajador = trabajadorService.getTrabajadorById(id);
        if (trabajador == null) {
            return ResponseEntity.notFound().build();
        }
        trabajadorService.deleteTrabajador(trabajador);
        return ResponseEntity.ok(trabajador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> updateUsuario(@RequestBody Trabajador trabajador, @PathVariable int id) {
        Trabajador currentTrabajador = trabajadorService.getTrabajadorById(id);
        if (currentTrabajador == null) {
            return ResponseEntity.notFound().build();
        } else {
            Persona persona = currentTrabajador.getPersona();
            persona.setNombre(trabajador.getPersona().getNombre());
            persona.setApellido(trabajador.getPersona().getApellido());
            persona.setTelefono(trabajador.getPersona().getTelefono());
            persona.setCorreo(trabajador.getPersona().getCorreo());
            currentTrabajador.setPersona(persona);
            Trabajador updatedTrabajador = trabajadorService.updateEncargado(currentTrabajador);
            return ResponseEntity.ok(updatedTrabajador);
        }
    }
}
