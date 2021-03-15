<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/10
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>modifyGrade</title>
</head>
<body>
<%
    String sid_cid = request.getParameter("grade");
    String str[] = sid_cid.split("_");
    String sid = str[0];
    String cid = str[1];
%>

<form method="post" action="modifyGradeServlet">
    <table>
        <tr>
            <td>Sid: </td><td><input type="text" readonly="readonly" name="sid" value="<%=sid%>"/></td>
        </tr>
        <tr>
            <td>Cid: </td><td><input type="text" readonly="readonly" name="cid" value="<%=cid%>"/></td>
        </tr>
        <tr>
            <td>new Grade: </td><td><input type="text" name="grade" onkeyup="value=value.replace(/[^\-?\d.]/g,'')" value=""/></td>
        </tr>
    </table>
    <input type="submit" value="提交" />
    <a href="main.jsp"><button type="button">返回主界面</button></a>

</form>
</body>
</html>
