package com.droovo.tn.usermessagingservice.Repositories;
import com.droovo.tn.usermessagingservice.Entites.Reclamation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReclamationRepository extends MongoRepository<Reclamation, Long> {
}
