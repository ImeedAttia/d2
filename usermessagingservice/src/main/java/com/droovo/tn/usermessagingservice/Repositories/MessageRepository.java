package com.droovo.tn.usermessagingservice.Repositories;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import com.droovo.tn.usermessagingservice.Entites.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
=======
import com.droovo.tn.usermessagingservice.Entites.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, Long> {
>>>>>>> rebuild

    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);
}
