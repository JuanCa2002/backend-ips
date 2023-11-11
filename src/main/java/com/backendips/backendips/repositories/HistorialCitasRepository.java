package com.backendips.backendips.repositories;

import com.backendips.backendips.models.HistorialCitas;
import com.backendips.backendips.models.enums.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface HistorialCitasRepository extends JpaRepository<HistorialCitas, Integer> {


    @Query("SELECT c FROM HistorialCitas c " +
            "WHERE (:numeroDocumento is null or c.cita.paciente.persona.numeroDocumento = :numeroDocumento )" +
            "AND (:idMedico is null or c.cita.medico.id = :idMedico)" +
            "AND (:cambio is null or c.cambio = :cambio)" +
            "AND (:fechaCita is null or DATE(c.cita.fecha) = :fechaCita)")
    List<HistorialCitas> findByFilter(String numeroDocumento, Integer idMedico, Cambio cambio, LocalDate fechaCita);
}
