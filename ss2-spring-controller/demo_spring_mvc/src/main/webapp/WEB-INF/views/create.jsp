
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 9/13/2023
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm mới</h2>
<form:form modelAttribute="student" action="/student/create" method="post">
    <form:input path="id"/><br>
    <form:input path="name"/><br>
    <form:radiobutton path="gender" value="1" label="Nam"/>
    <form:radiobutton path="gender" value="0" label="Nữ"/>
    <form:radiobutton path="gender" value="-1" label="LGBT"/><br>
<%--    <form:select path="className">--%>
<%--        <form:option value="C04" label="C04"/>--%>
<%--        <form:option value="C05" label="C05"/>--%>
<%--        <form:option value="C06" label="C06"/><br>--%>
<%--    </form:select>--%>
<%--    <form:select path="className" items="${classList}"/>--%>
    <form:select path="className">
        <form:option value="" label="Chọn"/>
        <form:options items="${classList}"/>
    </form:select>
    <form:checkbox path="languages" value="JS" label="JS"/>
    <form:checkbox path="languages" value="Java" label="Java"/>
    <form:checkbox path="languages" value="PHP" label="PHP"/><br>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
