package com.droovo.tn.shared.dto;

import com.droovo.tn.shared.dto.Enum.TypeUser;
import com.droovo.tn.shared.dto.Enum.UserStatus;

import java.sql.Timestamp;

public record UserDTO(
        Long id,
        int cin,
        String email,
        String displayName,
        Timestamp lastLogin,
        String photoURL,
        String uid,
        String phone,
        String plan,
        boolean isDriver,
        boolean isVerified,
        String password,
        // true => online, false => offline
        boolean status,
        // true => active, false => inactive
        boolean accountStatus,
        TypeUser type,
        UserStatus userStatus
) {}