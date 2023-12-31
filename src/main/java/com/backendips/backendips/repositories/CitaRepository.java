package com.backendips.backendips.repositories;

import com.backendips.backendips.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CitaRepository extends JpaRepository<Cita,Integer> {

    @Query("SELECT C FROM Cita C WHERE C.codigo= :id")
    Cita findCitaById(int id);

    @Query("SELECT C FROM Cita C\n" +
            "INNER JOIN Medico M\n" +
            "ON C.medico.idMedico = M.idMedico\n" +
            "INNER JOIN Persona P\n" +
            "ON M.persona.codigo = P.codigo\n" +
            "INNER JOIN EspecialidadMedico E\n" +
            "ON M.especialidadMedico.id = E.id\n" +
            "WHERE E.id= :especialidad\n" +
            "AND C.estadoCita.id = 1")
    List<Cita> findCitasByEspecialidad(int especialidad);

    @Query("SELECT C FROM Cita C\n" +
            "INNER JOIN Medico M\n" +
            "ON C.medico.idMedico = M.idMedico\n" +
            "INNER JOIN Persona P\n" +
            "ON M.persona.codigo = P.codigo\n" +
            "INNER JOIN EspecialidadMedico E\n" +
            "ON M.especialidadMedico.id = E.id\n" +
            "WHERE E.id= :especialidad\n" +
            "AND P.nombre like %:nombreMedico% "+
            "AND C.estadoCita.id = 1")
    List<Cita> findCitasByEspecialidadAndMedico(int especialidad, String nombreMedico);
}
