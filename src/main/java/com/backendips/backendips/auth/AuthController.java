package com.backendips.backendips.auth;

import com.backendips.backendips.models.Paciente;
import com.backendips.backendips.models.Trabajador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse token = authService.login(request);
        if(token != null){
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<String> createAdmin(@RequestBody Trabajador trabajador) {
        var hola = authService.createAdmin(trabajador);
        return ResponseEntity.ok("Administrador registrado");
    }
}
