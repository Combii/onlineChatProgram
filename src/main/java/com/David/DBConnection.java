package com.David;


import java.sql.*;

/**
 * Created by David Stovlbaek
 * 25 April 2017.
 */
public class DBConnection {

    private static Statement statement;
    private static DBConnection mySqlConnectionSingleton;
    public Connection connection;

    private DBConnection() {

        String url = "jdbc:mysql://databaserds.cb0dhoyk9s4v.eu-central-1.rds.amazonaws.com:3306/";
        String dbName = "Julius";
        String driver = "com.mysql.jdbc.Driver";
        String user = "julius";
        String pass = "12345678";

        try {
            connection = DriverManager.getConnection(url + dbName, user, pass);
        } catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static synchronized DBConnection getDbCon() {
        if (mySqlConnectionSingleton == null) {
            mySqlConnectionSingleton = new DBConnection();
        }
        return mySqlConnectionSingleton;
    }
}
