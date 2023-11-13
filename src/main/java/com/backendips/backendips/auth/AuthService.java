package com.backendips.backendips.auth;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.backendips.backendips.jwt.JwtService;
import com.backendips.backendips.models.Trabajador;
import com.backendips.backendips.repositories.PersonaRepository;
import com.backendips.backendips.repositories.TrabajadorRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PersonaRepository personaRepository;
    private final TrabajadorRepository trabajadorRepository;

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getNumberDocument(), request.getPassword()));
            UserDetails usuario = personaRepository.findByNumeroDocumento(request.getNumberDocument()).orElseThrow();
            String token = jwtService.getToken(usuario);
            return AuthResponse.builder().token(token).build();
        } catch (Exception ex) {
            return null;
        }
    }

    public Trabajador createAdmin(Trabajador admin) {
        admin.getPersona().getRol().setId(3);
        admin.getPersona().setPassword(passwordEncoder.encode(admin.getPersona().getPassword()));
        personaRepository.save(admin.getPersona());

        var toko = AuthResponse.builder()
                .token(jwtService.getToken(admin.getPersona()))
                .build();
        System.out.println("TOKEN: " + toko);

        return trabajadorRepository.save(admin);
    }
}
