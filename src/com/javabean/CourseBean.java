package com.javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseBean {
    private Connection connection;
    private Statement statement;

    public CourseBean() {
        try {
            connection = new ConToMysql().getConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            errorProcess(ex);
        }
    }


    public boolean delete (int cid) throws SQLException {

            boolean flag = statement.execute("DELETE FROM course WHERE cid = " + cid + ";");
            statement.execute("DELETE FROM grade WHERE cid = " + cid + ";");
            return flag;
    }

    public boolean update ( int oldCid, int newCid, String name ) throws SQLException{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE course SET cid =?,name=? WHERE cid = ? ");
            preparedStatement.setInt(1,newCid);
            preparedStatement.setString(2,name);
            preparedStatement.setInt(3,oldCid);
            boolean flag =preparedStatement.execute();
            return flag;

    }

    public boolean insert (int cid, String name ) throws SQLException{

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO course VALUE (?,?)");
            preparedStatement.setInt(1,cid);
            preparedStatement.setString(2,name);
            boolean flag = preparedStatement.execute();
            return flag;

    }

    public void errorProcess(Exception ex) {
        ex.toString();
    }




}