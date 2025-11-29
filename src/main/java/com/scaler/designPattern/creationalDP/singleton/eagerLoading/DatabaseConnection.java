package com.scaler.designPattern.creationalDP.singleton.eagerLoading;

public class DatabaseConnection {
    private static DatabaseConnection databaseConnection = new DatabaseConnection();

    private DatabaseConnection() {}

    // Not going to work in a concurrent environment
    public static DatabaseConnection getInstance() {
        return databaseConnection;
    }
}