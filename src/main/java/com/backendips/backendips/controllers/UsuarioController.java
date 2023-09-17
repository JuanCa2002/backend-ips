package com.backendips.backendips.controllers;


import com.backendips.backendips.models.Medico;
import com.backendips.backendips.models.Persona;
import com.backendips.backendips.models.Usuario;
import com.backendips.backendips.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){
           Usuario newUsuario = usuarioService.createUsuario(usuario);
           return ResponseEntity.ok(newUsuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios(){
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        if(usuarios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable int id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        if(usuario == null){
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario, @PathVariable int id){
        Usuario currentUsuario = usuarioService.getUsuarioById(id);
        if(currentUsuario == null){
            return ResponseEntity.notFound().build();
        }else{
            Persona persona = usuario.getPersona();
            persona.setNombre(usuario.getPersona().getNombre());
            persona.setApellido(usuario.getPersona().getApellido());
            persona.setTelefono(usuario.getPersona().getTelefono());
            persona.setCorreo(usuario.getPersona().getCorreo());
            currentUsuario.setPersona(persona);
            Usuario updatedUsuario = usuarioService.createUsuario(currentUsuario);
            return ResponseEntity.ok(updatedUsuario);
        }
    }


}
