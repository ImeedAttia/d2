package com.droovo.tn.rideservice.Entities;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "feedback")
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
    //to change only in user service
    @Id
    @Indexed
    @Setter(AccessLevel.MODULE)
    String uid;
    String userName;
    double rating;
    String comment;
    String RideId;
    Instant timestamp;
}
