package com.droovo.tn.usermessagingservice.Entites;

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
}
