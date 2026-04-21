package com.groupeAziz.demo.service;

import com.groupeAziz.demo.config.JwtService;
import com.groupeAziz.demo.dto.AuthRequest;
import com.groupeAziz.demo.dto.AuthResponse;
import com.groupeAziz.demo.dto.UtilisateurDTO;
import com.groupeAziz.demo.entity.Utilisateur;
import com.groupeAziz.demo.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(UtilisateurDTO utilisateurDTO) {
        // Check if user already exists
        if (utilisateurRepository.existsByCin(utilisateurDTO.getCin())) {
            throw new RuntimeException("User already exists with CIN: " + utilisateurDTO.getCin());
        }

        // Create new user
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setCin(utilisateurDTO.getCin());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setAdresse(utilisateurDTO.getAdresse());
        utilisateur.setRole(utilisateurDTO.getRole());
        utilisateur.setPassword(passwordEncoder.encode(utilisateurDTO.getPassword()));

        Utilisateur savedUser = utilisateurRepository.save(utilisateur);

        // Generate token
        String token = jwtService.generateToken(savedUser);

        return new AuthResponse(token, "Bearer", savedUser.getCin(), savedUser.getRole().name());
    }

    public AuthResponse login(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.getCin(),
                        authRequest.getPassword()
                )
        );

        Utilisateur utilisateur = utilisateurRepository.findByCin(authRequest.getCin())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(utilisateur);

        return new AuthResponse(token, "Bearer", utilisateur.getCin(), utilisateur.getRole().name());
    }
}
