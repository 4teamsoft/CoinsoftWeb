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
  <form name="loginform" id="loginform" class="wpl-track-me">
    <span class="chooisePlataform">Acceso a Plataforma</span>
    <input type="button" class="button-primary2" value="Administrador" onclick="location.href='user?action=access';" style="margin-top: 30px;"/>
    <!--<input type="button" class="button-primary2" value="Gestor" onclick="location.href='1.html';" style="margin-top: 30px;"/> -->
  </form>
</div>
</body>
</html>

