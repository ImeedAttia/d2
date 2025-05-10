package com.droovo.tn.usermessagingservice.Entites;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import com.droovo.tn.usermessagingservice.Entites.Enum.ApprovalStatus;
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeReclamation;

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
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate dateSoumission;
    LocalDate dateCloture;
    String titre;
    String description;
    @Enumerated(EnumType.STRING)
    TypeReclamation typeReclamation;
    @Enumerated(EnumType.STRING)
    ApprovalStatus status;
    @ManyToOne
    Utilisateur utilisateurReclamation;

=======
import com.droovo.tn.usermessagingservice.Entites.Enum.ApprovalStatus;
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeReclamation;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "reclamations")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reclamation {
    @Id
    Long id;
    LocalDate submissionDate;
    LocalDate dateResolution;
    String label;
    String description;
    TypeReclamation type;
    ApprovalStatus status;
    UserDetail user;
    String rideId;
>>>>>>> rebuild
}
