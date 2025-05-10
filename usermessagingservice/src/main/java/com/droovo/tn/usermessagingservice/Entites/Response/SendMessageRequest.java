package com.droovo.tn.usermessagingservice.Entites.Response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageRequest {
    private Long senderId;
    private Long receiverId;
    private String content;
}
