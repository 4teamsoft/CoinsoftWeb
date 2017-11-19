
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
          <input type="text" name="user" id="user" class="input" placeholder="Usuario" value="" size="20" />
        </p>
        <p class="login-password">
          <input type="password" name="pwd" id="pwd" class="input" placeholder="Contraseña" value="" size="20" />
        </p>
        <p class="login-submit">
          <input type="submit" class="button-primary" value="Ingresar" />
        </p>
     </fieldset>
  </form>
</div>
</body>
</html>

