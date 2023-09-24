package com.backendips.backendips.repositories;

import com.backendips.backendips.models.Cita;
import com.backendips.backendips.models.EstadoCita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EstadoCitaRepository extends JpaRepository<EstadoCita,Integer> {
    @Query("SELECT C FROM EstadoCita C WHERE C.id= :id")
    EstadoCita findEstadoCitaById(int id);
}
