package com.groupeAziz.demo.controller;

import com.groupeAziz.demo.dto.AuthRequest;
import com.groupeAziz.demo.dto.AuthResponse;
import com.groupeAziz.demo.dto.UtilisateurDTO;
import com.groupeAziz.demo.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody UtilisateurDTO utilisateurDTO) {
        return ResponseEntity.ok(authService.register(utilisateurDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Authentication working!");
    }
}