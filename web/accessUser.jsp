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
  <form name="loginform" id="loginform" action="#" method="post" class="wpl-track-me">
    <p class="login-username">
      <input type="text" name="user" id="user_login" class="input" placeholder="Usuario" value="" size="20" />
    </p>
    <p class="login-password">
      <input type="password" name="pwd" id="user_pass" class="input" placeholder="Contraseña" value="" size="20" />
    </p>
    <p class="login-submit"><input type="submit" name="wp-submit" id="wp-submit" class="button-primary" value="Ingresar" />
      <input type="hidden" name="redirect_to" value="#"/>
    </p>
  </form>
</div>
</body>
</html>

