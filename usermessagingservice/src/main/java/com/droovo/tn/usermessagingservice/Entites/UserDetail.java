package com.droovo.tn.usermessagingservice.Entites;

import com.droovo.tn.usermessagingservice.Entites.Enum.TypeUser;
import com.droovo.tn.usermessagingservice.Entites.Enum.UserStatus;
import com.droovo.tn.usermessagingservice.Entites.shared.CarClientDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Document(collection = "users")
@Data
@EqualsAndHashCode
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDetail {

    @Id
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
    CarClientDto car;
    public static UserDetail empty() {
        return new UserDetail();
    }
}
