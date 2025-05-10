package com.droovo.tn.usermessagingservice.Controller;

import com.droovo.tn.usermessagingservice.Entites.Message;
import com.droovo.tn.usermessagingservice.Entites.Response.SendMessageRequest;
import com.droovo.tn.usermessagingservice.Services.EmailService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatController {

    private final EmailService emailService;

    @PostMapping
    public Message sendMessassge(@RequestBody Message message) {
        message.setTimestamp(System.currentTimeMillis());
        return emailService.saveMessage(message);
    }

    @GetMapping
    public List<Message> getMessages() {
        return emailService.getAllMessages();
    }

    @GetMapping("/messages")
    public List<Message> getMessagesByUserIds(
            @RequestParam("senderId") Long senderId,
            @RequestParam("receiverId") Long receiverId) {
        return emailService.getMessagesByUserIds(senderId, receiverId);
    }

    @PostMapping("/send-message")
    public Message sendMessageBetweenUsers(@RequestBody SendMessageRequest request) {
        Long senderId = request.getSenderId();
        Long receiverId = request.getReceiverId();
        String content = request.getContent();

        return emailService.sendMessage(senderId, receiverId, content);
    }
}
