<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.javabean.ConToMysql" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/10
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addStudent</title>
</head>
<body>


<form method="post" action="addStudentServlet">

    sid: <input type="text" name="sid" value=""/><br/>
    studentName: <input type="text" name="name" value=""/><br/>
    sex: <input type="text" name="sex" value=""/><br/>
    <input type="submit" value="提交" />
    <a href="main.jsp"><button type="button">返回主界面</button></a>

</form>


</body>
</html>
