<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Thén
  Date: 17/09/2023
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
</head>
<body>
<form action="search">
    <label>Search: <input type="text" placeholder="Type your word" name="search"></label>
    <button type="submit">Search</button>
</form>
<p>${result}</p>
</body>
</html>
