package com.backendips.backendips.repositories;

import com.backendips.backendips.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query("SELECT p FROM Persona p WHERE p.codigo = (SELECT MAX(p2.codigo) FROM Persona p2)")
    Persona findLastPerson();

//    @Query("SELECT p FROM Persona p WHERE p.numero_documento = :numero_documento")
//    Persona findPersonaByNumero_documento(String numero_documento);


}
