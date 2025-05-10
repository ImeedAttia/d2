package com.droovo.tn.usermessagingservice.Entites.Enum;

import lombok.Getter;

@Getter
public enum TypeUser {
    ADMIN(1, "Administrateur"),
    DRIVER(2, "Chauffeur"),
    USER(3, "UserDetail");

    private final int id;
    private final String description;

    TypeUser(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static TypeUser valueOf(int id) {
        for (TypeUser type : values()) {
            if (type.id == id) return type;
        }
        throw new IllegalArgumentException("Invalid TypeUser ID: " + id);
    }
}
