<%--
  Created by IntelliJ IDEA.
  User: Văn Thén
  Date: 19/09/2023
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>

<body>
<h1>Sandwich Condiments</h1>
<form method="post" action="/save">
    <input type="checkbox" name="condiment" value="lettuce">Lettuce
    <input type="checkbox" name="condiment" value="tomato">Tomato
    <input type="checkbox" name="condiment" value="mustard">Mustard
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <hr style="width: 20%; margin-left: 0;">
    <input type="submit" id="submit" value="Save">
</form>

<c:if test="${not empty condiment}">
    <ol>
        <c:forEach items="${condiment}" var="item">
            <li>${item}</li>
        </c:forEach>
    </ol>
</c:if>
</body>
</html>