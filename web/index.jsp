<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 09/11/2017
  Time: 06:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Acceso a Plataforma Administrativa</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link href='https://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
</head>
<body>
<div id="main" class="container">
  <form name="loginform" id="loginform" action="users" method="post" class="wpl-track-me">
    <fieldset>
      <input type="hidden" name="action" value="index"/>
      <p class="login-username">
        <input type="text" name="user" id="user" class="input" placeholder="Usuario" value="${user.user}" size="20" />
      </p>
      <p class="login-password">
        <input type="password" name="pwd" id="pwd" class="input" placeholder="Contraseña" value="${user.pwd}" size="20" />
      </p>
      <p class="login-submit">
        <!--<a href="users?action=index" class="button-primary" style="margin-bottom: 10px;">Ingresar</a>-->
        <input type="submit" class="button-primary" value="Ingresar" />
      </p>
    </fieldset>
  </form>
</div>
</body>
</html>


