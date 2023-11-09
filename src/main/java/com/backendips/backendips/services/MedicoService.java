package com.backendips.backendips.services;

import com.backendips.backendips.models.Medico;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.models.Rol;
import com.backendips.backendips.repositories.MedicoRepository;
import com.backendips.backendips.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Medico createMedico(Medico medico){
        Persona persona = personaRepository.findLastPerson();
        if(persona == null){
            medico.getPersona().setId(1);
        }else{
            medico.getPersona().setId(persona.getId()+1);
        }
        //asignar Rol de Medico
        medico.getPersona().setRol(new Rol());
        medico.getPersona().getRol().setId(4);
//        medico.getPersona().setPassword(passwordEncoder.encode(medico.getPersona().getPassword()));
        medico.getPersona().setPassword(passwordEncoder.encode("123abc"));

        personaRepository.save(medico.getPersona());
        Medico newMedico = medicoRepository.save(medico);
        return newMedico;
    }

    public Medico updateMedico(Medico medico){
        personaRepository.save(medico.getPersona());
        Medico newMedico = medicoRepository.save(medico);
        return newMedico;
    }

    public List<Medico> getAllMedicos(){
        return medicoRepository.findAll();
    }

    public Medico getMedicoById(int id){
        return medicoRepository.findById(id).orElse(null);
    }

    public List<Medico> getMedicosPorEspecilidad(int id){
        return medicoRepository.findByIdEspecilidad(id);
    }

    public void deleteMedico(Medico medico){
        medicoRepository.delete(medico);
        personaRepository.delete(medico.getPersona());
    }
}
