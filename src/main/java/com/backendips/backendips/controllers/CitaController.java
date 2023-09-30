package com.backendips.backendips.controllers;

import com.backendips.backendips.models.Cita;
import com.backendips.backendips.models.Paciente;
import com.backendips.backendips.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
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


    @PutMapping
    public ResponseEntity<Cita> updateEstadoCita(@RequestParam("idCita") int idCita,@RequestParam("idEstadoCita") int idEstadoCita){
   Cita cita= citaService.getCitaById(idCita);
        if(cita == null){
            return ResponseEntity.notFound().build();
        }
        Cita citaAux= citaService.updateEstadoCita(idCita,idEstadoCita);
        return ResponseEntity.ok(citaAux);
    }

    @GetMapping("/medico/{idMedico}")
    public ResponseEntity<List<Cita>> getCitasByMedicoAndFecha(@PathVariable int idMedico,@RequestParam("fecha") String fecha){
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaAux = dateFormat.parse(fecha);
            List<Cita> citas=citaService.getCitasByMedicoAndFecha(idMedico,fechaAux);
            if(citas.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(citas);
        }catch (ParseException e){
            return ResponseEntity.badRequest().build();
        }

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

    @GetMapping("/cita_especialidad/{idEspecialidad}")
    public ResponseEntity<List<Cita>> getCitasByEspecialidad(@PathVariable int idEspecialidad){
        List<Cita> citas = citaService.getCitaByEspecialidad(idEspecialidad);
        if (citas == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/{idEspecialidad}/{nombreMedico}")
    public ResponseEntity<List<Cita>> getCitasByEspecialidadAndMedico(@PathVariable int idEspecialidad,@PathVariable String nombreMedico){
        List<Cita> citas = citaService.getCitaByEspecialidadAndMedico(idEspecialidad,nombreMedico);
        if (citas == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(citas);
    }


}
