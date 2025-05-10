package com.droovo.tn.usermessagingservice.Services.Impl.Reclamation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.droovo.tn.usermessagingservice.Entites.Enum.ApprovalStatus;
import com.droovo.tn.usermessagingservice.Entites.Reclamation;
import com.droovo.tn.usermessagingservice.Repositories.ReclamationRepository;
import com.droovo.tn.usermessagingservice.Services.Reclamation.ReclamationService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReclamationServiceImpl implements ReclamationService {
    ReclamationRepository reclamationRepository;
    @Override
    public Reclamation saveReclamation(Reclamation reclamation) {
        Reclamation r = reclamationRepository.findById(reclamation.getId()).orElse(null);
        reclamation.setStatus(ApprovalStatus.PENDING);
        return reclamationRepository.save(reclamation);
    }

    @Override
    public Reclamation getReclamationById(Long id) {
        Optional<Reclamation> reclamationOptional = reclamationRepository.findById(id);
        return reclamationOptional.orElse(null);
    }

    @Override
    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    @Override
    public Reclamation updateReclamation( Reclamation reclamation) {
        Reclamation reclamation1 = reclamationRepository.findById(reclamation.getId()).orElse(null);
        assert reclamation1 != null;
        reclamation1.setStatus(ApprovalStatus.valueOf(reclamation.getStatus().toString()));
        Reclamation r = reclamationRepository.save(reclamation1);
        return r;
    }

    @Override
    public void deleteReclamation(Long id) {
        reclamationRepository.deleteById(id);
    }

}