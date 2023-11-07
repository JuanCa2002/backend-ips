package com.backendips.backendips.services;

import com.backendips.backendips.models.Persona;
import com.backendips.backendips.models.Rol;
import com.backendips.backendips.models.Trabajador;
import com.backendips.backendips.repositories.PersonaRepository;
import com.backendips.backendips.repositories.TrabajadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Trabajador createEncargado(Trabajador trabajador){
        Persona persona = personaRepository.findLastPerson();
        if(persona == null){
            trabajador.getPersona().setId(1);
        }else{
            trabajador.getPersona().setId(persona.getId()+1);
        }

        //asignar Rol de Encargado
        trabajador.getPersona().setRol(new Rol());
        trabajador.getPersona().getRol().setId(2);
        trabajador.getPersona().setPassword(passwordEncoder.encode(trabajador.getPersona().getPassword()));
        
        personaRepository.save(trabajador.getPersona());
        Trabajador newTrabajador = trabajadorRepository.save(trabajador);
        return newTrabajador;
    }

    public Trabajador updateEncargado(Trabajador trabajador){
        personaRepository.save(trabajador.getPersona());
        Trabajador newTrabajador = trabajadorRepository.save(trabajador);
        return newTrabajador;
    }

    public List<Trabajador> getAllTrabajadores(){
        return trabajadorRepository.findAll();
    }

    public Trabajador getTrabajadorById(int id){
        return trabajadorRepository.findById(id).orElse(null);
    }

    public void deleteTrabajador(Trabajador trabajador){
        trabajadorRepository.delete(trabajador);
        personaRepository.delete(trabajador.getPersona());
    }
}
