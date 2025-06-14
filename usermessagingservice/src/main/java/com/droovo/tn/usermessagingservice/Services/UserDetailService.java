package com.droovo.tn.usermessagingservice.Services;

import com.droovo.tn.usermessagingservice.Entites.UserDetail;

import java.util.List;

public interface UserDetailService {
    UserDetail saveUserDetail(UserDetail userDetail);
    UserDetail getUserDetailById(String id);
    
    UserDetail getUserDetailByEmail(String email);

    List<UserDetail> getAllUserDetails();
    UserDetail updateUserDetail(String id, UserDetail userDetail);
    void deleteUserDetail(String id);

    long countUserDetail();
}
