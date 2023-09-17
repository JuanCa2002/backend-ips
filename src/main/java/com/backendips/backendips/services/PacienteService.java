package com.backendips.backendips.services;

import com.backendips.backendips.models.Medico;
import com.backendips.backendips.models.Paciente;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.repositories.PacienteRepository;
import com.backendips.backendips.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public Paciente createPaciente(Paciente paciente){
        Persona persona = personaRepository.findLastPerson();
        if(persona == null){
            paciente.getPersona().setCodigo(1);
        }else{
            paciente.getPersona().setCodigo(persona.getCodigo()+1);
        }
        personaRepository.save(paciente.getPersona());
        Paciente newPaciente = pacienteRepository.save(paciente);
        return newPaciente;
    }

    public Paciente updatePaciente(Paciente paciente){
        personaRepository.save(paciente.getPersona());
        Paciente newPaciente = pacienteRepository.save(paciente);
        return newPaciente;
    }

    public List<Paciente> getAllPacientes(){
        return pacienteRepository.findAll();
    }

    public Paciente getPacienteById(int id){
        return pacienteRepository.findById(id).orElse(null);
    }

    public void deletePaciente(Paciente paciente){
        pacienteRepository.delete(paciente);
        personaRepository.delete(paciente.getPersona());
    }


}
