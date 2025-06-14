package com.droovo.tn.apigateway.Entites.Auth;

import com.droovo.tn.apigateway.Entites.Enum.TypeUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
