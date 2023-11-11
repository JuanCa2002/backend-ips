package com.backendips.backendips.repositories;

import com.backendips.backendips.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita,Integer> {

    @Query("SELECT C FROM Cita C WHERE C.id= :id")
    Cita findCitaById(int id);

    @Query("SELECT C FROM Cita C\n" +
            "INNER JOIN Medico M\n" +
            "ON C.medico.id = M.id\n" +
            "INNER JOIN Persona P\n" +
            "ON M.persona.id = P.id\n" +
            "INNER JOIN EspecialidadMedico E\n" +
            "ON M.especialidad.id = E.id\n" +
            "WHERE E.id= :especialidad\n" +
            "AND C.estadoCita.id in (1,2)" +
            "AND C.fecha > CURDATE()")

    List<Cita> findCitasByEspecialidad(int especialidad);

    @Query("SELECT C FROM Cita C\n" +
            "INNER JOIN Medico M\n" +
            "ON C.medico.id = M.id\n" +
            "INNER JOIN Persona P\n" +
            "ON M.persona.id = P.id\n" +
            "INNER JOIN EspecialidadMedico E\n" +
            "ON M.especialidad.id = E.id\n" +
            "WHERE E.id= :especialidad\n" +
            "AND P.nombre like %:nombreMedico% "+
            "AND C.estadoCita.id in (1,2)" +
            "AND C.fecha > CURDATE()")

    List<Cita> findCitasByEspecialidadAndMedico(int especialidad, String nombreMedico);

    @Query("SELECT C FROM Cita C WHERE DATE(C.fecha)=:fecha AND C.medico.id=:idMedico")
    List<Cita>findCitasByMedicoAndFecha(int idMedico, Date fecha);
    //fecha debe ser en formato 'YYYY-MM-DD';

    @Query("SELECT C FROM Cita C\n" +
            "INNER JOIN Paciente PA\n" +
            "ON C.paciente.id = PA.id\n" +
            "INNER JOIN Persona PE\n" +
            "ON PA.persona.id = PE.id\n" +
            "WHERE PE.numeroDocumento = :numeroDocumento\n" +
            "AND C.estadoCita.id = :idEstadoCita")
    List<Cita>findCitasByCedulaAndIdEstadoCita(String numeroDocumento, int idEstadoCita);
}

