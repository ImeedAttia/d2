package com.droovo.tn.usermessagingservice.Entites;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeFeedBack;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String libelle;
     LocalDate dateSoumission;
     String description;
     @Enumerated(EnumType.STRING)
     TypeFeedBack typeFeedBack;
     @ManyToOne
     Utilisateur utilisateurEmployeFeedBack;

=======
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeFeedBack;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "feedbacks")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FeedBack {
    @Id
    Long id;
    String label;
    LocalDate submissionDate;
    String description;
    TypeFeedBack type;
    @DBRef
    UserDetail employee;
>>>>>>> rebuild
}
