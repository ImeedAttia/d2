package com.droovo.tn.usermessagingservice.Entites;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @ManyToOne
    private com.droovo.tn.usermessagingservice.Entites.Utilisateur sender;
    @ManyToOne
    private Utilisateur receiver;
=======
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
>>>>>>> rebuild
    private Long timestamp;

}
