package com.javabean;

import java.sql.*;

public class StudentBean {
    private Connection connection;
    private Statement statement;

    public StudentBean() {
        try {
            connection = new ConToMysql().getConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            errorProcess(ex);
        }
    }


    public boolean delete (int sid) throws SQLException {
        boolean flag = statement.execute("DELETE FROM student WHERE sid = " + sid + ";");
        statement.execute("DELETE FROM grade WHERE sid = " + sid + ";");
        return flag;
    }

    public String update ( int oldSid, int newSid, String name, String sex ) throws SQLException {
        if (sex.equals("male") ||sex.equals("female")) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET sid =?,name=?,sex=? WHERE sid = ? ");
            preparedStatement.setInt(1, newSid);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, sex);
            preparedStatement.setInt(4, oldSid);
            boolean flag = preparedStatement.executeUpdate()>0;
            if (flag)
                return "Modify successfully!";
            else
                return "Error, maybe this record was deleted just now.";
        } else
            return "Wrong input!(sex must choose from \"male\", \"female\")";

    }

    public String insert (int sid, String name, String sex) throws SQLException {
        if (name.equals(""))
            return "name can not be empty!";
        if (sid <= 0)
            return "sid must >0!";
        if (sex.equals("male") ||sex.equals("female")) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student VALUE (?,?,?)");
            preparedStatement.setInt(1,sid);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,sex);
            preparedStatement.execute();
            return "Insert successfully!";
        } else
            return "Wrong input!(sex must choose from \"male\", \"female\")";
    }

    public void errorProcess(Exception ex) {
        ex.toString();
    }



}