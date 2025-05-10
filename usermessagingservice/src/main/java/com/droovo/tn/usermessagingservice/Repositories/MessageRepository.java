package com.droovo.tn.usermessagingservice.Repositories;

import com.droovo.tn.usermessagingservice.Entites.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, Long> {
    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
