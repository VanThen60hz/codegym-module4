<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Văn Thén
  Date: 20/09/2023
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        body{
            text-align: center;
        }
    </style>
</head>
<body>

    <h2>Calculator</h2>
    <form method="post" action="/calculate">
        <div>
            <label>
                Number 1:
                <input type="number" name="num1" placeholder="Enter number 1">
            </label>
            <label>
                Number 2:
                <input type="number" name="num2" placeholder="Enter number 2">
            </label>
            <input type="hidden" name="operator" id="operator">
        </div>
        <br><br>
        <div>
            <button type="submit" onclick="document.getElementById('operator').value = '+'">Addition (+)</button>
            <button type="submit" onclick="document.getElementById('operator').value = '-'">Subtraction (-)</button>
            <button type="submit" onclick="document.getElementById('operator').value = '*'">Multiplication (*)</button>
            <button type="submit" onclick="document.getElementById('operator').value = '/'">Division (/)</button>
        </div>
    </form>

    <c:if test="${not empty result}">
        <b>${result}</b>
    </c:if>
</body>
</html>
