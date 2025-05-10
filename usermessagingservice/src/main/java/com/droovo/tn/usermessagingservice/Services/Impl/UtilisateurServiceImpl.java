package com.droovo.tn.usermessagingservice.Services.Impl;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.droovo.tn.usermessagingservice.Entites.Utilisateur;
import com.droovo.tn.usermessagingservice.Repositories.UtilisateurRepository;
import com.droovo.tn.usermessagingservice.Services.UtilisateurService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        return utilisateurOptional.orElse(null);
    }

    @Override
    public Utilisateur getUtilisateurByEmail(String email) {
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findByEmail(email);
        return utilisateurOptional.orElse(null);
    }

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur existingUtilisateur = optionalUtilisateur.get();
            existingUtilisateur.setDisplayName(utilisateur.getDisplayName());
            existingUtilisateur.setEmail(utilisateur.getEmail());
            existingUtilisateur.setPhotoURL(utilisateur.getPhotoURL());
            existingUtilisateur.setPassword(passwordEncoder.encode(existingUtilisateur.getPassword()));
            existingUtilisateur.setType(utilisateur.getType());
            existingUtilisateur.setStatus(utilisateur.isStatus());

            return utilisateurRepository.save(existingUtilisateur);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public long countUtilisateur() {
        return utilisateurRepository.count();
    }

    //get the current loggedIn user
    public static String getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails userDetails) {
            username = userDetails.getUsername();
            // use username or userDetails as needed
        } else {
            username = principal.toString();
            // handle cases where the principal is not an instance of UserDetails
        }
        return username;
    }

}