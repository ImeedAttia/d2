package com.droovo.tn.rideservice.Entities;

import com.droovo.tn.rideservice.Entities.Enum.SeatStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "seats")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Seat {
    @Id
    int uid;
    SeatStatus status;
    String reservedBy;
    @DBRef
    private Car car;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
