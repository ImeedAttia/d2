package com.droovo.tn.usermessagingservice.Entites.Response;

<<<<<<< HEAD
=======
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
>>>>>>> rebuild
public class SendMessageRequest {
    private Long senderId;
    private Long receiverId;
    private String content;

    public SendMessageRequest() {
    }

    public SendMessageRequest(Long senderId, Long receiverId, String content) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.content = content;
    }

<<<<<<< HEAD
    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
=======
>>>>>>> rebuild
}
