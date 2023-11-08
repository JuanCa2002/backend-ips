package com.backendips.backendips.controllers;


import com.backendips.backendips.models.Medico;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.services.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medico")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;


    @PostMapping
    public ResponseEntity<String> createMedico(@RequestBody Medico medico){
        Medico newMedico = medicoService.createMedico(medico);
        return ResponseEntity.ok("Medico creado con éxito");
    }

    @GetMapping
    public ResponseEntity<List<Medico>> getAllMedicos(){
        List<Medico> medicos = medicoService.getAllMedicos();
        if(medicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/especialistas/{id}")
    public ResponseEntity<List<Medico>> getMedicosEspecialistasById(@PathVariable int id){
        List<Medico> medicos = medicoService.getMedicosPorEspecilidad(id);
        if(medicos.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> getMedicoById(@PathVariable int id){
        Medico medico = medicoService.getMedicoById(id);
        if(medico == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(medico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Medico> deleteMedico(@PathVariable int id){
        Medico medico = medicoService.getMedicoById(id);
        if(medico == null){
            return ResponseEntity.notFound().build();
        }
        medicoService.deleteMedico(medico);
        return ResponseEntity.ok(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> updateMedico(@RequestBody Medico medico ,@PathVariable int id){
         Medico currentMedico = medicoService.getMedicoById(id);
         if(currentMedico== null){
             return ResponseEntity.notFound().build();
         }else{
             currentMedico.setTarjetaProfesional(medico.getTarjetaProfesional());
             Persona persona = currentMedico.getPersona();
             persona.setNombre(medico.getPersona().getNombre());
             persona.setApellido(medico.getPersona().getApellido());
             persona.setTelefono(medico.getPersona().getTelefono());
             persona.setCorreo(medico.getPersona().getCorreo());
             currentMedico.setPersona(persona);
             Medico updatedMedico = medicoService.updateMedico(currentMedico);
             return ResponseEntity.ok(updatedMedico);
         }
    }

}
