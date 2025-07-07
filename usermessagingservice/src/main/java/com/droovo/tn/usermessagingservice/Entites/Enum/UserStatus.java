package com.droovo.tn.usermessagingservice.Entites.Enum;

public enum UserStatus {
    ONLINE,
    OFFLINE,
    CLOSED,
    LOCKED,
    PENDING,
    UNKNOWN,
    BUSY,
    AWAY,
    INVISIBLE,
    DO_NOT_DISTURB;


    public static UserStatus fromString(String status) {
        try {
            return UserStatus.valueOf(status.toUpperCase());
        } catch (Exception e) {
            return OFFLINE;
        }
    }
}
