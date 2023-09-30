package com.backendips.backendips.repositories;

import com.backendips.backendips.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    @Query("SELECT m FROM Medico m WHERE m.especialidadMedico.id = :id")
    List<Medico> findByIdEspecilidad(int id);
}
