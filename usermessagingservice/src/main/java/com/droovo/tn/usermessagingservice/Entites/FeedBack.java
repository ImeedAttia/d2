package com.droovo.tn.usermessagingservice.Entites;

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
}
