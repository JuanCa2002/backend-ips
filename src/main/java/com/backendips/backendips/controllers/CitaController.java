package com.backendips.backendips.controllers;

import com.backendips.backendips.models.Cita;
import com.backendips.backendips.models.Paciente;
import com.backendips.backendips.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cita")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public ResponseEntity<List<Cita>> getAllCitas(){
        List<Cita> citas=citaService.getAllCitas();
        if (citas.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(citas);
    }

    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita){
        Cita citaAux=citaService.createCita(cita);
        return ResponseEntity.ok(citaAux);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> getCitaById(@PathVariable int id){
        Cita cita = citaService.getCitaById(id);
        if(cita == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cita);
    }

    @PutMapping("/{idCita}")
    public ResponseEntity<Cita> updateCitaPaciente(@PathVariable int idCita,@RequestParam("idPaciente") int idPaciente){
        Cita cita= citaService.getCitaById(idCita);
        if(cita == null){
            return ResponseEntity.notFound().build();
        }
        Cita citaAux= citaService.updateCitaPaciente(idCita,idPaciente);
        return ResponseEntity.ok(citaAux);
    }

    @PutMapping("/{idCita}/{idEstadoCita}")
    public ResponseEntity<Cita> updateEstadoCita(@PathVariable int idCita,@PathVariable int idEstadoCita){
        Cita cita= citaService.getCitaById(idCita);
        if(cita == null){
            return ResponseEntity.notFound().build();
        }
        Cita citaAux= citaService.updateEstadoCita(idCita,idEstadoCita);
        return ResponseEntity.ok(citaAux);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cita> deleteCita(@PathVariable int id){
        Cita cita = citaService.getCitaById(id);
        if(cita == null){
            return ResponseEntity.notFound().build();
        }
        citaService.deleteCita(id);
        return ResponseEntity.ok(cita);

    }
}
