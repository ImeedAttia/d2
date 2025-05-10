package com.droovo.tn.usermessagingservice.Services.Reclamation;

import com.droovo.tn.usermessagingservice.Entites.Reclamation;

import java.util.List;

public interface ReclamationService {
    Reclamation saveReclamation(Reclamation reclamation);
    Reclamation getReclamationById(Long id);
    List<Reclamation> getAllReclamations();
    Reclamation updateReclamation(Reclamation reclamation);
    void deleteReclamation(Long id);
}
