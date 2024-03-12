package com.tpk.JooqAccessLayer.dto;

import lombok.Builder;

@Builder
public record AddressDao(
        int addressID,
        int userID,
        String street,
        String city,
        String state,
        String postal_code

) {
    public static final String ADDRESS = "address";
    public static final String ADDRESS_ID = "address_id";
    public static final String USERID = "user_id";
    public static final String STREET = "street";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String POSTAL_CODE = "postal_code";
}
