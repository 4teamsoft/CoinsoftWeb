<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 11/11/2017
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>New Visit</title>
</head>

<body>
<h1>New Visit</h1>
<form action="visits" method="post">
    <fieldset>
        <input type="hidden" name="action" value="create"/>
        <jsp:include page="_users_fieldset.jsp"/>
    </fieldset>
</form>
<p><a href="visits?action=index">Visits List</a> </p>
</body>
</html>
