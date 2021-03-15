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

    <title>addGrade</title>
</head>
<body>
<%-- ConToMysql() --%>
<%
    ArrayList<String[]> student = new ArrayList<String[]>();
    ArrayList<String[]> course = new ArrayList<String[]>();
    try {
        Connection connection = new ConToMysql().getConnection();
        ResultSet rsStudent = connection.createStatement().executeQuery("SELECT * FROM student");
        ResultSet rsCourse = connection.createStatement().executeQuery("SELECT * FROM course");

        student.clear();
        while (rsStudent.next()) {
            student.add(new String[]{rsStudent.getString(1),rsStudent.getString(2)});
        }

        course.clear();
        while (rsCourse.next()) {
            course.add(new String[]{rsCourse.getString(1),rsCourse.getString(2)});
        }


    } catch (SQLException ex) {
        out.print("服务器与数据库连接错误，请联系管理员<br>");
        out.print(ex.toString());
    }
%>

<form method="post" action="addGradeServlet" onsubmit="">
    student: <select name="sid">
     <%
         Iterator itStudent = student.iterator();
         while (itStudent.hasNext()) {
             String[] studentInfo = (String[]) itStudent.next();
             String sid = studentInfo[0];
             String sName = studentInfo[1];
             out.print("<option value="+sid+">"+sName+"(id: "+sid+")"+"</option>");
         }
     %>
    </select>
    course: <select name="cid">
    <%
        Iterator itCourse = course.iterator();

        while (itCourse.hasNext()) {
            String[] courseInfo = (String[]) itCourse.next();
            String cid = courseInfo[0];
            String cName = courseInfo[1];
            out.print("<option value="+cid+">"+cName+"(id: "+cid+")"+"</option>");
        }
    %>
</select>
    grade: <input type="text" name="grade" id="grade" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" value=""><br>
    <input type="submit" value="提交" >
    <a href="main.jsp"><button type="button">返回主界面</button></a>
</form>
</body>
</html>
