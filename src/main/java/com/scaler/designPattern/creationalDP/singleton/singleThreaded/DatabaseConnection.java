package com.scaler.designPattern.creationalDP.singleton.singleThreaded;

//This is single threaded singleton class
public class DatabaseConnection {
    private static DatabaseConnection databaseConnection = null;

    private DatabaseConnection() {}

    // Not going to work in a concurrent environment
    public static DatabaseConnection getInstance() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }

        return databaseConnection;
    }
}