<%@ page import="java.sql.Connection" %>
<%@ page import="com.javabean.ConToMysql" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.sun.rowset.CachedRowSetImpl" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/10
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%-- javscript代码 --%>
    <script type="text/javascript">

        function confirmStudentUpdate() {
            var r=confirm("Are you sure to update this student record ?");
            if (r==true)
            {
                document.studentForm.action="modifyStudent.jsp";
                document.studentForm.submit();
            }
            else
            {
                alert("You pressed Cancel!");
            }
        }
        function confirmStudentDelete() {
            var r=confirm("Are you sure to delete this student record ?");
            if (r==true)
            {
                document.studentForm.action="deleteStudentServlet";
                document.studentForm.submit();
            }
            else
            {
                alert("You pressed Cancel!");
            }
        }
        function confirmCourseUpdate() {
            var r=confirm("Are you sure to update this course record ?");
            if (r==true)
            {
                document.courseForm.action="modifyCourse.jsp";
                document.courseForm.submit();
            }
            else
            {
                alert("You pressed Cancel!");
            }
        }
        function confirmCourseDelete() {
            var r=confirm("Are you sure to delete this course record ?");
            if (r==true)
            {
                document.courseForm.action="deleteCourseServlet";
                document.courseForm.submit();
            }
            else
            {
                alert("You pressed Cancel!");
            }
        }
        function confirmGradeUpdate() {
            var r=confirm("Are you sure to update this grade record ?");
            if (r==true)
            {
                document.gradeForm.action="modifyGrade.jsp";
                document.gradeForm.submit();
            }
            else
            {
                alert("You pressed Cancel!");
            }
        }
        function confirmGradeDelete() {
            var r=confirm("Are you sure to delete this grade record ?");
            if (r==true)
            {
                document.gradeForm.action="deleteGradeServlet";
                document.gradeForm.submit();
            }
            else
            {
                alert("You pressed Cancel!");
            }
        }

    </script>

    <title>main</title>
</head>
<body>

<%--确认登录信息，连接数据库--%>
<%
    boolean isLogin =false;
    try {
       isLogin = (boolean) session.getAttribute("isLogin");
    } catch (Exception ex ) {
        isLogin =false;
    }
    if (!isLogin)     {
            out.print("请先登录，3秒后跳转至登录页面");
            response.setHeader("refresh", "3;URL=login.jsp");
    } else {
        out.print("Hello!<br>");
        out.print(session.getAttribute("name")+"<br>");
        try {
            Connection connection = new ConToMysql().getConnection();
            ResultSet rsStudent = connection.createStatement().executeQuery("SELECT * FROM student");
            ResultSet rsCourse = connection.createStatement().executeQuery("SELECT * FROM course");
            ResultSet rsGrade = connection.createStatement().executeQuery("SELECT * FROM grade");
%>

<%-- 展示table Student --%>
    <form name="studentForm" method="post" action="">
          <a href="addStudent.jsp"><button type="button">新增学生记录</button></a>
                <button type="button" onclick="confirmStudentUpdate()">修改学生记录</button>
                <button type="button" onclick="confirmStudentDelete()">删除学生记录</button>
                <table>
                <tr>
                    <th></th>
                    <th>sid</th>
                    <th>name</th>
                    <th>sex</th>
                </tr>
                    <%
                        while (rsStudent.next()) {

                            out.print("<tr>");
                            out.print("<td><input type='radio' name='student' value='"+rsStudent.getInt(1)+"'/></td>");
                            out.print("<td>" + rsStudent.getInt(1) + "</td><td>" + rsStudent.getString(2) + "</td><td>" + rsStudent.getString(3) + "</td>");
                            out.print("</tr>");
                        }
                    %>
                </table>
    </form>
<br/>

<%-- 展示table Course --%>
    <form name="courseForm" action="modifyCourse.jsp" method="post">
        <a href="addCourse.jsp"><button type="button">新增课程记录</button></a>
            <button type="button" onclick="confirmCourseUpdate()">修改课程记录</button>
            <button type="button" onclick="confirmCourseDelete()">删除课程记录</button>
               <table>
                   <tr>
                       <th></th><th>cid</th><th>name</th>
                   </tr>
<%
                while (rsCourse.next()) {

                    out.print("<tr>");
                    out.print("<td><input type='radio' name='course' value='"+rsCourse.getInt(1)+"'/></td>");
                    out.print("<td>" + rsCourse.getInt(1) + "</td><td>" + rsCourse.getString(2) + "</td>");
                    out.print("</tr>");
                }
%>
                </table>
    </form>
<br/>

<%-- 展示table Grade --%>
    <form name="gradeForm" action="modifyGrade.jsp" method="post">
        <a href="addGrade.jsp"><button type="button">新增成绩记录</button></a>
            <button type="button" onclick="confirmGradeUpdate()">修改成绩记录</button>
            <button type="button" onclick="confirmGradeDelete()">删除成绩记录</button>
                <table>
                    <tr>
                        <th></th><th>sid</th><th>cid</th><th>score</th>
                    </tr>
<%
                while (rsGrade.next()) {
                    out.print("<tr>");
                    out.print("<td><input type='radio' name='grade' value='"+rsGrade.getInt(1)+"_"+rsGrade.getInt(2)+"'/></td>");
                    out.print("<td>" + rsGrade.getInt(1) + "</td><td>" + rsGrade.getInt(2) + "</td><td>" + rsGrade.getString(3) + "</td>");
                    out.print("</tr>");
                }
%>

                </table>
    </form>

<%
        } catch (SQLException ex) {

            out.print("服务器与数据库连接错误，请联系管理员<br>");
            out.print(ex.toString());
        }
    }
%>


</body>
</html>
