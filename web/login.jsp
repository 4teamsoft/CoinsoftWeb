<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 11/11/2017
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Access</title>
</head>
<body>
<h1>Product Information</h1>
<s:form action="user">

    <s:label for="username" value="UserName"/>
    <s:textfield id="username" name="username"/>

    <s:label for="password" value="Password"/>
    <s:textfield id="password" name="password"/>

    <s:submit value="Save"/>

</s:form>
</body>
</html>
