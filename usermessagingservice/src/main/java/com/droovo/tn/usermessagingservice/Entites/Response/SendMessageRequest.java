package com.droovo.tn.usermessagingservice.Entites.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageRequest {
    private String senderId;
    private String receiverId;
    private String content;
}
