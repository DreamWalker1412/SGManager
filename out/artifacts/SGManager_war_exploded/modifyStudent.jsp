<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/3
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modifyStudent</title>
</head>
<body>
<form method="post" action="modifyStudentServlet">
    <table>
        <tr>
            <td>old Sid: </td><td><input type="text" readonly="readonly"  name="oldSid" value="<%=request.getParameter("student")%>"/></td>
        </tr>
        <tr>
            <td>new Sid: </td><td><input type="text" name="newSid" value="<%=request.getParameter("student")%>"/></td>
        </tr>
        <tr>
            <td>new Name: </td><td><input type="text" name="name" value=""/></td>
        </tr>
        <tr>
            <td>new sex: </td><td><input type="text" name="sex" value=""/></td>
        </tr>
    </table>
    <input type="submit" value="提交" />
    <a href="main.jsp"><button type="button">返回主界面</button></a>

</form>
</body>
</html>
