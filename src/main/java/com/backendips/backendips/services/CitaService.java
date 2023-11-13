package com.backendips.backendips.services;

import com.backendips.backendips.models.Cita;
import com.backendips.backendips.models.Paciente;
import com.backendips.backendips.repositories.CitaRepository;
import com.backendips.backendips.repositories.EstadoCitaRepository;
import com.backendips.backendips.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CitaService {


    @Autowired
    private CitaRepository citaRepository;

    @Autowired
    private EstadoCitaRepository estadoCitaRepository;

    @Autowired
    private PacienteService pacienteService;

    public Cita createCita(Cita cita) {
        //cita.setEstadoCita(estadoCitaRepository.findEstadoCitaById(1));
        Cita newCita = citaRepository.save(cita);
        return newCita;
    }

    public Cita updateCitaPaciente(int idCita, int idPaciente) {

        Cita cita = citaRepository.findCitaById(idCita);
        if (cita == null) {
            return null;
        } else {
            Paciente paciente = pacienteService.getPacienteById(idPaciente);
            if(paciente==null){
                return null;
            }
            cita.setPaciente(paciente);
            //cita.setEstadoCita(estadoCitaRepository.findEstadoCitaById(3));
            citaRepository.save(cita);
        }
        return cita;
    }

    public Cita updateEstadoCita(int idCita, int idEstadoCita) {
        Cita cita = citaRepository.findCitaById(idCita);
        if (cita == null) {
            return null;
        } else {
            if (idEstadoCita != 4) {
                cita.setPaciente(null);
            }
            cita.setEstadoCita(estadoCitaRepository.findEstadoCitaById(idEstadoCita));
            citaRepository.save(cita);
        }
        return cita;
    }

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public Cita getCitaById(int id) {
        return citaRepository.findCitaById(id);
    }

    public boolean deleteCita(int idCita) {
        Cita cita = citaRepository.findCitaById(idCita);
        if (cita == null) {
            return false;
        } else {
            citaRepository.delete(cita);
            return true;
        }
    }

    public List<Cita> getCitaByEspecialidad(int idEspecialidad){
        return citaRepository.findCitasByEspecialidad(idEspecialidad);
    }

    public List<Cita>getCitaByEspecialidadAndMedico(int idEspecialidad,String nombreMedico){
        return citaRepository.findCitasByEspecialidadAndMedico( idEspecialidad,nombreMedico);
    }

    public List<Cita>getCitasByMedicoAndFecha(int idMedico, Date fecha){
        return citaRepository.findCitasByMedicoAndFecha(idMedico,fecha);
    }

    public List<Cita>getCitasByCedulaAndIdEstadoCita(String numeroDocumento, int idEstadoCita){
        return citaRepository.findCitasByCedulaAndIdEstadoCita(numeroDocumento, idEstadoCita);
    }

    public List<Cita>getCitasByPacienteAndMedicoAndEstadoCitaAndFecha(int idPaciente, int idMedico){
        return citaRepository.findCitasByPacienteAndMedicoAndEstadoCitaAndFecha(idPaciente,idMedico);
    }
}
