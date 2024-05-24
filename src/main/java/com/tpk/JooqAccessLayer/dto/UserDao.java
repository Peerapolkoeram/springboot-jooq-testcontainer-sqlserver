package com.tpk.JooqAccessLayer.dto;

import lombok.Builder;
import org.jooq.Record;

@Builder
public record UserDao(
        int userID,
        String username,
        String password,
        String email,
        String firstname,
        String lastname

)  {
    public static final String USERS = "users";
    public static final String USERNAME = "username";
    public static final String USERID = "user_id";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
}
