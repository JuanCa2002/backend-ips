package com.backendips.backendips.repositories;

import com.backendips.backendips.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CitaRepository extends JpaRepository<Cita,Integer> {

    @Query("SELECT C FROM Cita C WHERE C.codigo= :id")
    Cita findCitaById(int id);
}
