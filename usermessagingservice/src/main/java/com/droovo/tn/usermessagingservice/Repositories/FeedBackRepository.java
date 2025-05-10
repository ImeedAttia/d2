package com.droovo.tn.usermessagingservice.Repositories;

import com.droovo.tn.usermessagingservice.Entites.FeedBack;
import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FeedBackRepository extends MongoRepository<FeedBack, Long> {
    List<FeedBack> findById(String id);
}
