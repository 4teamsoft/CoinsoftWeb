
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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


