package com.sellAnyThing.sellAnyThing;

import java.sql.Timestamp;

public class Constants {

    public static final String API_SECRET_KEY = "sellAnythingApi@Vodafone969";
    public static final long TOKEN_VALIDITY = 2 * 60 * 60 * 1000;

    public static String getTimeStampInMillis() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return String.valueOf(timestamp.getTime());
    }
}
