package com.backendips.backendips.services;

import com.backendips.backendips.models.Medico;
import com.backendips.backendips.models.Paciente;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.models.Rol;
import com.backendips.backendips.repositories.PacienteRepository;
import com.backendips.backendips.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Paciente createPaciente(Paciente paciente){
        Persona lastPerson = personaRepository.findLastPerson();
        if(lastPerson == null){
            paciente.getPersona().setId(1);
        }else{
            paciente.getPersona().setId(lastPerson.getId()+1);
        }
        //asignar Rol de Paciente
        paciente.getPersona().setRol(new Rol());
        paciente.getPersona().getRol().setId(1);
//        paciente.getPersona().setPassword(passwordEncoder.encode(paciente.getPersona().getPassword()));
        paciente.getPersona().setPassword(passwordEncoder.encode("123abc"));

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

    public Paciente getPacienteByDocumento(String numero_documento){
       Paciente paciente = pacienteRepository.findPacienteByNumeroDocumento(numero_documento);
       if(paciente == null){
           return null;
       }
       return paciente;
    }
}
