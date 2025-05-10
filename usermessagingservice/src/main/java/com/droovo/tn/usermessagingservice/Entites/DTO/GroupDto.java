package com.droovo.tn.usermessagingservice.Entites.DTO;

import com.droovo.tn.usermessagingservice.Entites.MemberList;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

public class GroupDto {
    Long id;
    String name;
    List<MemberList> members;
}
