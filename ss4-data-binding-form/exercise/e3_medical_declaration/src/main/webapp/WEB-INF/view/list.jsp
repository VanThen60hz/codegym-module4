<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.3.2/css/bootstrap.min.css"/>
</head>
<body>
<div class="row">
    <div class="col-11 ps-5"><h2>List Heath Declare</h2></div>
    <div class="col-1"><a class="btn btn-success" href="/form">Add new</a></div>
</div>

<table class="table">
    <thead>
    <th>Ho va ten</th>
    <th>Nam sinh</th>
    <th>Dien thoai</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="e" items="${res}">
        <tr>
            <td>${e.fullName}</td>
            <td>${e.yearBirthday}</td>
            <td>${e.phone}</td>
            <td>
                <a href="/form/ + ${e.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>