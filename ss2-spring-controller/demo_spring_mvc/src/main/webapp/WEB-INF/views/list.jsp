<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Home
  Date: 9/13/2023
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Trang danh sách</h1>
<p>${mess}</p>
<a href="/student/create"> Thêm mới</a>
<table>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Name</th>
        <th>Gender</th>
        <th>ClassName</th>
        <th>Language</th>
        <th>Detail-RequestParam</th>
        <th>Detail-PathVariable</th>
    </tr>
    <c:forEach var="student" items="${studentList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.className}</td>
            <td>
                <c:forEach var="lang" items="${student.languages}">
                    <span>${lang} </span>
                </c:forEach>
            </td>
            <td>
                <a href="/student/detail?id=${student.id}">Detail1</a>
            </td>
            <td>
                <a href="/student/detail/${student.id}">Detail2</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
