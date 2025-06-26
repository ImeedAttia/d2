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
) {
    public UserDTO() {
        this(0L, 0, "", "", new Timestamp(System.currentTimeMillis()), "", "", "", "", false, false, "", true, true, TypeUser.USER, UserStatus.UNKNOWN);
    }

    public UserDTO(Long id, int cin, String email, String displayName, Timestamp lastLogin, String photoURL,
                   String uid, String phone, String plan, boolean isDriver, boolean isVerified,
                   String password, boolean status, boolean accountStatus,
                   TypeUser type, UserStatus userStatus) {
        this.id = id;
        this.cin = cin;
        this.email = email;
        this.displayName = displayName;
        this.lastLogin = lastLogin;
        this.photoURL = photoURL;
        this.uid = uid;
        this.phone = phone;
        this.plan = plan;
        this.isDriver = isDriver;
        this.isVerified = isVerified;
        this.password = password;
        this.status = status;
        this.accountStatus = accountStatus;
        this.type = type;
        this.userStatus = userStatus;
    }
}