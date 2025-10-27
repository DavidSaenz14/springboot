package com.example.springboot.controllers;

import com.example.springboot.dtos.LoginRequest;
import com.example.springboot.dtos.LoginResponse;
import com.example.springboot.models.Usuarios;
import com.example.springboot.services.UsuariosService;
import com.example.springboot.security.CustomUserDetailsService;
import com.example.springboot.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 🔹 LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getCorreoElectronico(), request.getContraseña())
            );

            UserDetails userDetails = userDetailsService.loadUserByUsername(request.getCorreoElectronico());
            String token = jwtUtil.generateToken(userDetails);

            String rol = userDetails.getAuthorities().stream()
                    .findFirst()
                    .map(a -> a.getAuthority().replace("ROLE_", ""))
                    .orElse("");

            return ResponseEntity.ok(new LoginResponse(token, rol));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    // 🔹 REGISTER
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuarios usuario) {
        try {
            Usuarios nuevoUsuario = usuariosService.crearUsuario(usuario);
            return ResponseEntity.ok(nuevoUsuario);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 🔹 CHECK USER
    @GetMapping("/check")
    public ResponseEntity<?> checkUserExists(@RequestParam String username, @RequestParam String email) {
        boolean exists = usuariosService.findByNombre(username).isPresent()
                || usuariosService.findByCorreoElectronico(email).isPresent();
        return ResponseEntity.ok(exists);
    }
}
