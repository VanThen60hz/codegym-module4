<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" action="/" novalidate="novalidate" enctype="multipart/form-data" modelAttribute="song">
    <input type="hidden" name="id" value="0">
    <table>
        <tr>
            <td>Name:</td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>Artist:</td>
            <td>
                <form:input path="artist"/>
            </td>
        </tr>
        <tr>
            <td>Genre:</td>
            <td>
                <form:input path="genre"/>
            </td>
        </tr>
        <tr>
            <td>File:</td>
            <td>
                <form:input path="file" type="file" accept=".mp3,.wav,.ogg,.m4p"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>


</form:form>
</body>
</html>