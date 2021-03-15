<%@ page import="com.javabean.ConToMysql" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/11
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginCheck</title>
</head>
<body>

<%

    String tId = request.getParameter("tId").trim();
    String pwd = request.getParameter("pwd").trim();

    if(!tId.matches("[0-9]+")) {
        out.print("教师ID输入格式不正确<br>3秒后返回登陆页面");
        response.setHeader("refresh", "3;URL=login.jsp");
    }
    else if(tId.isEmpty()) {
        out.print("教师ID不能为空!<br>3秒后返回登陆页面");
        response.setHeader("refresh", "3;URL=login.jsp");
    } else if (pwd.isEmpty()) {
        out.print("令牌不能为空!<br>3秒后返回登陆页面");
        response.setHeader("refresh", "3;URL=login.jsp");
    } else {
        Connection connection = new ConToMysql().getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("SELECT name FROM teacher WHERE tid = ? AND password = ?");
            pstm.setInt(1, Integer.valueOf(tId));
            pstm.setString(2, pwd);
            ResultSet resultSet = pstm.executeQuery();
            if (!resultSet.next()) {
                out.print("教师ID或密码输入有误<br>3秒后返回登陆页面");
                response.setHeader("refresh", "3;URL=login.jsp");
            }
            else {
                session.setAttribute("tId", tId);
                session.setAttribute("name",resultSet.getString(1));
                session.setAttribute("isLogin",(boolean)true);
                //request.getRequestDispatcher("main.jsp").forward(request,response);
                response.setHeader("refresh", "0;URL=/main");
            }
        } catch (SQLException ex) {
            out.print(ex.toString());
            out.print("数据库连接错误，请检查网络稍后再试<br>若仍不成功请联系数据库管理员");
        }
    }

%>
</body>
</html>
