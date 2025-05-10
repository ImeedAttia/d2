package com.droovo.tn.usermessagingservice.Entites;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.util.List;

@Document(collection = "MemberList")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberList {
    String displayName;
    String uid;
    boolean isAdmin;
    boolean isMember;
    boolean requestAccepted;
    List<Integer> seatsRequested;
    double price;
    Timestamp timestemp;
}
