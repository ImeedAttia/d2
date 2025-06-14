package com.droovo.tn.shared.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupDTO {
    String uid;
    Long id;
    String name;
    List<MemberListDTO> members;
    Instant createdAt;
    Instant updatedAt;
}