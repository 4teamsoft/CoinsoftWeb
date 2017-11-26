w<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 11/11/2017
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CoinSoft - User List</title>
</head>
<body>
<h1>User List</h1>
<table>
    <tr>
        <th>Id</th>
        <th>User</th>
        <th>Name</th>
    </tr>
    <c:forEach var="user" items="${user}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td>
                <a href="user?action=show&id=${user.id}">Show</a>
                <a href="user?action=edit&id=${user.id}">Edit</a>
            </td>
        </tr>

    </c:forEach>

</table>
<a href="user?action=new">New user</a>
</body>
</html>
