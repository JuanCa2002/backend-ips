package com.backendips.backendips.services;

import com.backendips.backendips.models.Medico;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.models.Usuario;
import com.backendips.backendips.repositories.MedicoRepository;
import com.backendips.backendips.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public Medico createMedico(Medico medico){
        Persona persona = personaRepository.findLastPerson();
        if(persona == null){
            medico.getPersona().setCodigo(1);
        }else{
            medico.getPersona().setCodigo(persona.getCodigo()+1);
        }
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

    public void deleteMedico(Medico medico){
        medicoRepository.delete(medico);
        personaRepository.delete(medico.getPersona());
    }
}
