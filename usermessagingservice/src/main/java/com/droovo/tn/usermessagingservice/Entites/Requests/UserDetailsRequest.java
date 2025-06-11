package com.droovo.tn.usermessagingservice.Entites.Requests;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class UserDetailsRequest {
    String id;
    String uid;
    int cin;
    String displayName;
    String email;
    String photoURL;
    String phone;
    boolean isVerified;
    String password;
}
