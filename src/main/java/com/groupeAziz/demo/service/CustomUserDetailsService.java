package com.groupeAziz.demo.service;

import com.groupeAziz.demo.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String cin) throws UsernameNotFoundException {
        return utilisateurRepository.findByCin(cin)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with CIN: " + cin));
    }
}
