<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 11/11/2017
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>create a new employe</title>
</head>
<body>
<s:form action="employe">

    <s:label for="username" value="UserName"/>
    <s:textfield id="username" name="username"/>

    <s:label for="password" value="Password"/>
    <s:textfield id="password" name="password"/>

    <s:label for="type" value="type select"/>
    <s:textfield id="type" name="type"/>

    <s:label for="dni" value="DNI of Employe"/>
    <s:textfield id="dni" name="dni"/>

    <s:label for="name" value="Name of Employe"/>
    <s:textfield id="name" name="name"/>

    <s:label for="lastname" value="Last Name of Employe"/>
    <s:textfield id="lastname" name="lastname"/>

    <s:label for="age" value="Age of Employe"/>
    <s:textfield id="age" name="age"/>

    <s:label for="mail" value="Mail of Employe"/>
    <s:textfield id="mail" name="mail"/>

    <s:submit value="Save"/>

</s:form>
</body>
</html>
