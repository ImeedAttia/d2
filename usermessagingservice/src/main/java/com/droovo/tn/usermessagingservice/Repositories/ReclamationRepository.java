package com.droovo.tn.usermessagingservice.Repositories;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import com.droovo.tn.usermessagingservice.Entites.Reclamation;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {
=======
import com.droovo.tn.usermessagingservice.Entites.Reclamation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReclamationRepository extends MongoRepository<Reclamation, Long> {
>>>>>>> rebuild
}
