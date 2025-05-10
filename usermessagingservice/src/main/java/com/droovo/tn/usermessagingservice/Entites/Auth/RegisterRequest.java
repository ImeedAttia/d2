package com.droovo.tn.usermessagingservice.Entites.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeUser;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String displayName;
    private String email;
    private String password;
    private TypeUser role;
}
