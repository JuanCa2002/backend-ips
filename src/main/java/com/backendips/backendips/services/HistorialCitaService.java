package com.backendips.backendips.services;

import com.backendips.backendips.models.HistorialCitas;
import com.backendips.backendips.models.enums.Cambio;
import com.backendips.backendips.repositories.HistorialCitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class HistorialCitaService {

    @Autowired
    private HistorialCitasRepository historialCitasRepository;

    public HistorialCitas create(HistorialCitas historialCitas){
        historialCitas.setFechaModificacion(LocalDate.now());
        historialCitas.setHoraModificacion(LocalTime.now());
        HistorialCitas newHistorialCitas = historialCitasRepository.save(historialCitas);
        return newHistorialCitas;
    }

    public List<HistorialCitas> findHistorialByFilter(Integer idMedico, Cambio cambio, LocalDate fechaCita){
        List<HistorialCitas> historialCitas = historialCitasRepository.findByFilter( idMedico, cambio, fechaCita);
        if(historialCitas.isEmpty()){
            return null;
        }
        return historialCitas;
    };
}
