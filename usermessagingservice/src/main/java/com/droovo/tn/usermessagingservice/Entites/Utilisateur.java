package com.droovo.tn.usermessagingservice.Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.droovo.tn.usermessagingservice.Entites.Enum.TypeUser;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Utilisateur implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    boolean accountStatus;
    @Enumerated(EnumType.STRING)
    TypeUser type;

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
