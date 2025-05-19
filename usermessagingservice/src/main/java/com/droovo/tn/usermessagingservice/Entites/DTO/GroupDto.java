package com.droovo.tn.usermessagingservice.Entites.DTO;

import com.droovo.tn.usermessagingservice.Entites.MemberList;
import  com.droovo.tn.shared.dto.CarDTO;
import java.util.List;

public class GroupDto {
    Long id;
    String name;
    List<MemberList> members;
    com.droovo.tn.shared.dto.CarDTO car;
}
