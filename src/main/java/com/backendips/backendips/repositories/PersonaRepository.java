package com.backendips.backendips.repositories;

import com.backendips.backendips.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query("SELECT p FROM Persona p WHERE p.id = (SELECT MAX(p2.id) FROM Persona p2)")
    Persona findLastPerson();

    Optional<Persona> findByNumeroDocumento(String numeroDocumento);

    @Query("SELECT p FROM Persona p WHERE p.id= :id")
    Persona findPersonaById(int id);
//    @Query("SELECT p FROM Persona p WHERE p.numero_documento = :numero_documento")
//    Persona findPersonaByNumero_documento(String numero_documento);
}
