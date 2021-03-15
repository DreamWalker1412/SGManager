package com.javabean;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.*;

public class GradeBean {

    private Connection connection;
    private Statement statement;
    public GradeBean() {
        try {
            connection = new ConToMysql().getConnection();
            statement = connection.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean delete (int sid,int cid) throws SQLException {
        boolean flag = statement.execute("DELETE FROM grade WHERE sid=" + sid + " AND cid ="+cid+";");
        return flag;
    }

    public String update ( int sid, int cid, double score ) throws SQLException {
            if (score<0 || score>100) {
                return "Fail, grade must between 0~100!";
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement("UPDATE grade SET score=? WHERE sid = ? AND cid = ? ");
                preparedStatement.setDouble(1, score);
                preparedStatement.setInt(2, sid);
                preparedStatement.setInt(3, cid);
                boolean flag = preparedStatement.executeUpdate()>0;
                if (flag)
                    return "Modify successfully!";
                else
                    return "Fail, maybe this record was deleted.";
            }
    }

    public String insert (int sid, int cid, double score ) throws SQLException {
            if (score<0 || score>100) {
                return "Wrong input, grade must between 0~100!";
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO grade VALUE (?,?,?)");
                preparedStatement.setInt(1,sid);
                preparedStatement.setInt(2,cid);
                preparedStatement.setDouble(3,score);
                preparedStatement.execute();
                return "Insert successfully!";
            }

    }

    public void errorProcess(Exception ex) {
        ex.toString();
    }

}