package com.dao;

import java.sql.Connection;
import java.util.*;
import java.sql.*;
import java.io.*;

public class DBConnectionManager {

    private static Connection con = null;
    private static Properties properties = new Properties();

    public static Connection getConnection() {

        try {
            FileInputStream fis = new FileInputStream("database.properties");
            properties.load(fis);

            Class.forName(properties.getProperty("drivername"));
            con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));

            return con;

        } catch (ClassNotFoundException | SQLException | IOException e) {

        }

        return con;
    }
}
