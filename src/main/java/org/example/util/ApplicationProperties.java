package org.example.util;

public class ApplicationProperties {
    public static final String DATABASE_NAME = "postgres@localhost";
    public static final String DATABASE_URL =
            "jdbc:postgresql://localhost:5432/postgres" + DATABASE_NAME;
    public static final String DATABASE_USER = "postgres";
    public static final String DATABASE_PASSWORD = "postgres";
}
