package com.javabean;


import java.sql.*;

public class ConToMysql {

    private Connection connection;


    public ConToMysql () {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sgm";
            connection = DriverManager.getConnection(url,"root","root");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }


}