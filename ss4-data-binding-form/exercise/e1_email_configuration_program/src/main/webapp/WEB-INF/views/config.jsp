<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Thén
  Date: 27/09/2023
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Config</title>
</head>
<body>
<h1>Setting</h1>
<table>
<form:form modelAttribute="setting" action="/save" method="post">
    <tr>
        <td>Languages</td>
        <td>
            <form:select path="language" items="${languages}"/>
        </td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>
            Show
            <form:select path="pageSize" items="${pageSize}"/>
            emails per page
        </td>
    </tr>
    <tr>
        <td>Spams Filter:</td>
        <td>
            <form:checkbox path="spamFilter" value="true" />
        </td>
    </tr>
    <tr>
        <td>Signature</td>
        <td>
            <form:textarea path="signature" rows="7" cols="20" />
        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <button type="submit">Update</button>
            <button onclick="window.location = '/'">Cancel</button>
        </td>
    </tr>
</form:form>
</table>
</body>
</html>
