package com.droovo.tn.usermessagingservice.Repositories;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import com.droovo.tn.usermessagingservice.Entites.FeedBack;
import com.droovo.tn.usermessagingservice.Entites.Utilisateur;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findByUtilisateurEmployeFeedBack(Utilisateur user);
=======
import com.droovo.tn.usermessagingservice.Entites.FeedBack;
import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedBackRepository extends MongoRepository<FeedBack, Long> {
    List<FeedBack> findById(String id);
>>>>>>> rebuild
}
