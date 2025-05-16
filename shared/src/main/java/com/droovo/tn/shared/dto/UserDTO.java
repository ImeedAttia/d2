package com.droovo.tn.shared.dto;

import com.droovo.tn.shared.dto.ENUM.TypeUser;
import com.droovo.tn.shared.dto.ENUM.UserStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO implements UserDetails {

    Long id;
    int cin;
    String email;
    String displayName;
    Timestamp lastLogin;
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
    boolean accountStatus = true;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return accountStatus;
    }
}
