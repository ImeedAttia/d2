package com.droovo.tn.usermessagingservice.Services;
import com.droovo.tn.usermessagingservice.Entites.Message;
import com.droovo.tn.usermessagingservice.Entites.UserDetail;

import java.util.List;

public interface EmailService {
    void sendSimpleEmail(String to, String subject, String text);
    void sendEmailWithTemplate(UserDetail user);
    List<Message> getAllMessages();
    Message saveMessage(Message message);
    List<Message> getMessagesByUserIds(Long senderId, Long receiverId);

    Message sendMessage(Long senderId, Long receiverId, String content);
}
