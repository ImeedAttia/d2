package com.droovo.tn.usermessagingservice.Repositories;

import com.droovo.tn.usermessagingservice.Entites.Utilisateur;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UtilisateurRepository  extends MongoRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
}
