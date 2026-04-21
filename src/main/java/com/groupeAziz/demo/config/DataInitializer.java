/* package com.groupeAziz.demo.config;

import com.groupeAziz.demo.entity.Role;
import com.groupeAziz.demo.entity.Utilisateur;
import com.groupeAziz.demo.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Create admin user if not exists
        if (!utilisateurRepository.existsByCin("admin")) {
            Utilisateur admin = new Utilisateur();
            admin.setCin("admin");
            admin.setNom("Admin");
            admin.setPrenom("System");
            admin.setAdresse("Administration Office");
            admin.setRole(Role.ADMIN);
            admin.setPassword(passwordEncoder.encode("admin123"));

            utilisateurRepository.save(admin);
            System.out.println("Admin user created successfully!");
        }

        // Create a visitor user for testing
        if (!utilisateurRepository.existsByCin("visitor")) {
            Utilisateur visitor = new Utilisateur();
            visitor.setCin("visitor");
            visitor.setNom("Visitor");
            visitor.setPrenom("Test");
            visitor.setAdresse("Visitor Address");
            visitor.setRole(Role.VISITEUR);
            visitor.setPassword(passwordEncoder.encode("visitor123"));

            utilisateurRepository.save(visitor);
            System.out.println("Visitor user created successfully!");
        }

        // Create a moderator user for testing
        if (!utilisateurRepository.existsByCin("moderator")) {
            Utilisateur moderator = new Utilisateur();
            moderator.setCin("moderator");
            moderator.setNom("Moderator");
            moderator.setPrenom("Test");
            moderator.setAdresse("Moderator Address");
            moderator.setRole(Role.MODERATEUR);
            moderator.setPassword(passwordEncoder.encode("moderator123"));

            utilisateurRepository.save(moderator);
            System.out.println("Moderator user created successfully!");
        }
    }
} */

