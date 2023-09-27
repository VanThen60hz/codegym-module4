
<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 9/13/2023
  Time: 9:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm mới</h2>
<form:form modelAttribute="student" action="/student/create" method="post">
    Id
    <form:input path="id"/><br>
    Name
    <form:input path="name"/><br>
    Gender
    <form:radiobutton path="gender" value="1" label="Nam"/>
    <form:radiobutton path="gender" value="0" label="Nữ"/>
    <form:radiobutton path="gender" value="-1" label="LGBT"/><br>
<%--    <form:select path="className">--%>
<%--        <form:option value="A02" label="A02"/>--%>
<%--        <form:option value="A03" label="A03"/>--%>
<%--        <form:option value="A04" label="A04"/>--%>
<%--    </form:select><br>--%>
    <form:select path="className" items="${classList}"/>
    <form:checkboxes path="languages" items="${languages}"/>
    <form:button>Save</form:button>
</form:form>
</body>
</html>
