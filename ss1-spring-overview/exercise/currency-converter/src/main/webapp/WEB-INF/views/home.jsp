<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--@elvariable id="result" type=""--%>
<%--
  Created by IntelliJ IDEA.
  User: Văn Thén
  Date: 15/09/2023
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <style>
        .none {
            display: none;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/convert" method="post">
    <label><input type="text" name="usd"> USD</label>
    <label class="none">Rate: <input type="text" name="rate" value="24250"></label>
    <button type="submit">Convert</button>
</form>
<c:if test="${not empty result}">
    <p>${result} VND</p>
</c:if>
</body>
</html>
