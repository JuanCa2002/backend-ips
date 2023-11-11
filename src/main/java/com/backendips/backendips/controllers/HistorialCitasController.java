package com.backendips.backendips.controllers;

import com.backendips.backendips.models.HistorialCitas;
import com.backendips.backendips.models.enums.Cambio;
import com.backendips.backendips.services.HistorialCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/historialCita")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class HistorialCitasController {

    @Autowired
    private HistorialCitaService historialCitaService;

    @PostMapping
    public ResponseEntity<HistorialCitas> create(@RequestBody HistorialCitas historialCitas){
        HistorialCitas historialCitasSaved = historialCitaService.create(historialCitas);
        return new ResponseEntity<>(historialCitasSaved, HttpStatus.CREATED);
    }

    @GetMapping("/historial")
    public ResponseEntity<?> getHistorialByFilter(@RequestParam(name = "numeroDocumento", required = false) String numeroDocumento
            , @RequestParam(name = "idMedico", required = false) Integer idMedico, @RequestParam(name = "cambio", required = false) Cambio cambio,
                                                  @RequestParam(name = "fechaCita", required = false ) LocalDate fechaCita) {
        List<HistorialCitas> historialCitas = historialCitaService.findHistorialByFilter(numeroDocumento, idMedico, cambio, fechaCita);
        if (historialCitas == null){
            return new ResponseEntity<>("No se encontro nada", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(historialCitas, HttpStatus.OK);
    }
}
