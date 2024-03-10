package com.tpk.JooqAccessLayer.dto;

import lombok.Builder;

@Builder
public record UserDao(
        int userID,
        String username,
        String password,
        String email,
        String firstname,
        String lastname

) {
    public static final String USERS = "users";
    public static final String USERNAME = "username";
}
