package com.droovo.tn.apigateway.Entites.Requests;

import lombok.Data;

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
