<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.javabean.ConToMysql" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/10
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addCourse</title>
</head>
<body>

<%--
    ArrayList<String[]> course = new ArrayList<String[]>();
    try {
        Connection connection = new ConToMysql().getConnection();
        ResultSet rsCourse = connection.createStatement().executeQuery("SELECT * FROM course");

        course.clear();
        while (rsCourse.next()) {
            course.add(new String[]{rsCourse.getString(1),rsCourse.getString(2)});
        }


    } catch (SQLException ex) {
        out.print("服务器与数据库连接错误，请联系管理员<br>");
        out.print(ex.toString());
    }
--%>

<form method="post" action="addCourseServlet">

    cid: <input type="text" name="cid" value=""><br>
    couseName: <input type="text" name="name" value=""><br>
    <input type="submit" value="提交" >
    <a href="main.jsp"><button type="button">返回主界面</button></a>
</form>


</body>
</html>
