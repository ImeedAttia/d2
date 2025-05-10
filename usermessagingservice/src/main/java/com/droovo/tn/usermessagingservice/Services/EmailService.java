package com.droovo.tn.usermessagingservice.Services;
import com.droovo.tn.usermessagingservice.Entites.Message;
<<<<<<< HEAD
import com.droovo.tn.usermessagingservice.Entites.Utilisateur;
=======
import com.droovo.tn.usermessagingservice.Entites.UserDetail;
>>>>>>> rebuild

import java.util.List;

public interface EmailService {
    void sendSimpleEmail(String to, String subject, String text);
<<<<<<< HEAD
    void sendEmailWithTemplate(Utilisateur user);
=======
    void sendEmailWithTemplate(UserDetail user);
>>>>>>> rebuild
    List<Message> getAllMessages();
    Message saveMessage(Message message);
    List<Message> getMessagesByUserIds(Long senderId, Long receiverId);

    Message sendMessage(Long senderId, Long receiverId, String content);
}
