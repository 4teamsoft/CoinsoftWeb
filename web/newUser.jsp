<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 11/11/2017
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>New User</title>
</head>
<body>
<h1>New User</h1>
<form action="users" method="post">
    <fieldset>
        <input type="hidden" name="action" value="create"/>
        <jsp:include page="_users_fieldset.jsp"/>
    </fieldset>
</form>
<p><a href="users?action=index">Users List</a> </p>
</body>
</html>
