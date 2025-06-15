package com.droovo.tn.apigateway.Entites;

import com.droovo.tn.apigateway.Entites.Enum.TypeUser;
import com.droovo.tn.apigateway.Entites.Enum.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetail implements UserDetails {
    String id;

    int cin;
    String email;
    String displayName;
    Date lastLogin;
    String photoURL;
    String uid;
    String phone;
    String plan;
    boolean isDriver;
    boolean isVerified;
    String password;
    // true => online, false => offline
    boolean status;
    // true => active, false => inactive
    boolean accountStatus;
    TypeUser type;
    UserStatus userStatus;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(type.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Add logic if needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Add logic if needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Add logic if needed
    }

    @Override
    public boolean isEnabled() {
        return true; // Could use `status` or `accountStatus` for logic
    }
}
