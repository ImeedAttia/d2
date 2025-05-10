package com.droovo.tn.usermessagingservice.Repositories;

import com.droovo.tn.usermessagingservice.Entites.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDetailRepository  extends MongoRepository<UserDetail, Long> {
    Optional<UserDetail> findByEmail(String email);
}
