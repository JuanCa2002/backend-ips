package com.backendips.backendips.services;

import com.backendips.backendips.models.Persona;
import com.backendips.backendips.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final PasswordEncoder passwordEncoder;

    public Persona getByDocument(String numberDocument) {
        Optional<Persona> personaOpcional = personaRepository.findByNumeroDocumento(numberDocument);
        return personaOpcional.orElse(null);
    }

    public boolean putPassword(String numberDocument, String currentPassword, String newPassword) {
        Persona personaAux = getByDocument(numberDocument);
        String currentPasswordBD = personaAux.getPassword();

        if (passwordEncoder.matches(currentPassword, currentPasswordBD)) {
            personaAux.setPassword(passwordEncoder.encode(newPassword));
            personaRepository.save(personaAux);
            return true;
        }
        return false;
    }

    public Persona put(Persona persona) {
        Persona personaAux = getByDocument(persona.getNumeroDocumento());

        personaAux.setNombre(persona.getNombre());
        personaAux.setApellido(persona.getApellido());
        personaAux.setTipoIdentificacion(persona.getTipoIdentificacion());
        personaAux.setNumeroDocumento(persona.getNumeroDocumento());
        personaAux.setTelefono(persona.getTelefono());
        personaAux.setCorreo(persona.getCorreo());

        return personaRepository.save(personaAux);
    }
}
