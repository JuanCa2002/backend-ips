package com.backendips.backendips.controllers;

import com.backendips.backendips.models.Medico;
import com.backendips.backendips.models.Paciente;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paciente")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> createPaciente(@RequestBody Paciente paciente){
        Paciente newPaciente = pacienteService.createPaciente(paciente);
        return ResponseEntity.ok(newPaciente);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> getAllPacientes(){
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        if(pacientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getPacienteById(@PathVariable int id){
        Paciente paciente = pacienteService.getPacienteById(id);
        if(paciente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> deletePaciente(@PathVariable int id){
        Paciente paciente = pacienteService.getPacienteById(id);
        if(paciente == null){
            return ResponseEntity.notFound().build();
        }
        pacienteService.deletePaciente(paciente);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> updatePaciente(@RequestBody Paciente paciente, @PathVariable int id){
        Paciente currentPaciente = pacienteService.getPacienteById(id);
        if(currentPaciente == null){
            return ResponseEntity.notFound().build();
        }else{
            Persona persona = paciente.getPersona();
            persona.setNombre(paciente.getPersona().getNombre());
            persona.setApellido(paciente.getPersona().getApellido());
            persona.setTelefono(paciente.getPersona().getTelefono());
            persona.setCorreo(paciente.getPersona().getCorreo());
            persona.setTipo_identificacion(paciente.getPersona().getTipo_identificacion());
            currentPaciente.setPersona(persona);
            currentPaciente.setEps(paciente.getEps());
            Paciente updatedPaciente = pacienteService.createPaciente(currentPaciente);
            return ResponseEntity.ok(updatedPaciente);
        }
    }
}
