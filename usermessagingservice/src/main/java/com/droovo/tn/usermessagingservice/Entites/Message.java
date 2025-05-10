package com.droovo.tn.usermessagingservice.Entites;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {
    @Id
    private Long id;
    private String content;
    @DBRef(lazy = true)
    private UserDetail sender;
    @DBRef(lazy = true)
    private UserDetail receiver;
    private Long timestamp;

}
