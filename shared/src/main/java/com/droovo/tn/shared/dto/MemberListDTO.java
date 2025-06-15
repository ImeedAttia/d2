package com.droovo.tn.shared.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MemberListDTO {
    String uid;
    UserDTO user;
    boolean isAdmin;
    boolean isMember;
    boolean requestAccepted;
    List<Integer> seatsRequested;
    double price;
    Timestamp timestamp;
    Instant createdAt;
    Instant updatedAt;
}