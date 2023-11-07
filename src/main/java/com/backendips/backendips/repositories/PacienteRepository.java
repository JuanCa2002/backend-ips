package com.backendips.backendips.repositories;

import com.backendips.backendips.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

    @Query("SELECT pa FROM Paciente pa INNER JOIN Persona pe ON pa.persona.id = pe.id WHERE pe.numeroDocumento = :numero_documento")
    Paciente findPacienteByNumeroDocumento(String numero_documento);
}
