<%--
  Created by IntelliJ IDEA.
  User: nguyentronghiep
  Date: 05/04/2023
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Hello Servlet</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 32px;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #DDD;
        }

        tr:hover {background-color: #D6EEEE;}
    </style>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>position</th>
        <th>ssn</th>
    </tr>
    <c:forEach var="physician" items="${physicians}">
        <tr>
            <td>${physician.id}</td>
            <td>${physician.name}</td>
            <td>${physician.position}</td>
            <td>${physician.ssn}</td>
        </tr>
    </c:forEach>

</table>

<form method="post" action="/hello-servlet">
    <input type="text" name="name" placeholder="name">
    <input type="text" name="position" placeholder="position">
    <input type="text" name="ssn" placeholder="ssn">
    <button type="submit">submit</button>
</form>
</body>
</html>
