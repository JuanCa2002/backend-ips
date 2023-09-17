package com.backendips.backendips.services;

import com.backendips.backendips.models.Persona;
import com.backendips.backendips.models.Usuario;
import com.backendips.backendips.repositories.PersonaRepository;
import com.backendips.backendips.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaRepository personaRepository;

    public Usuario createUsuario(Usuario usuario){
        Persona persona = personaRepository.findLastPerson();
        if(persona == null){
            usuario.getPersona().setCodigo(1);
        }else{
            usuario.getPersona().setCodigo(persona.getCodigo()+1);
        }
        personaRepository.save(usuario.getPersona());
        Usuario newUsuario = usuarioRepository.save(usuario);
        return newUsuario;
    }

    public Usuario updateUsuario(Usuario usuario){
        personaRepository.save(usuario.getPersona());
        Usuario newUsuario = usuarioRepository.save(usuario);
        return newUsuario;
    }

    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public void deleteUsuario(Usuario usuario){
        usuarioRepository.delete(usuario);
        personaRepository.delete(usuario.getPersona());
    }
}
