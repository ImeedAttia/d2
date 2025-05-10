package com.droovo.tn.rideservice.DTO;

import com.droovo.tn.rideservice.Entities.Car;
import com.droovo.tn.rideservice.Entities.FeedBack;
import com.droovo.tn.rideservice.Entities.RideTargetSourceLocation;
import lombok.*;
import java.util.List;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetail {

    private String uid;
    private String email;
    private String displayName;
    private String photoURL;
    private String phone;
    private String plan;
    private boolean isDriver;
    private boolean isVerified;
    private List<Car> car;
    private List<RideTargetSourceLocation> favRideTargetSourceLocation;
    private List<FeedBack> feedbacks;
}

