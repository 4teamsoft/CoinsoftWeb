<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 13/11/2017
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>

    <title>CoinSoft</title>

    <meta charset="utf-8" />
    <link rel="icon" type="image/png" href="img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <%@include file="/shared/header.jsp"%>

</head>
<body>

<div class="wrapper">

    <%@include file="/shared/sidebar.jsp"%>

    <div class="main-panel">

        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Mi Cartera de Clientes</a>
                </div>

                <%@include file="/shared/navbar.jsp"%>

            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <a href="customers?action=new" class="btn btn-info btn-fill" style="margin-bottom: 10px;">Nuevo Cliente</a>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Clientes Activos</h4>
                                <p class="category">Solo se muestra los clientes activos</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    <tr>
                                        <th>NAME</th>
                                        <th>LAST Name</th>
                                        <th>AGE</th>
                                        <th>EMAIL</th>
                                        <th></th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="sector" items="${sectors}">
                                        <tr>
                                            <td><c:out value="${sector.id}"/></td>
                                            <td><c:out value="${sector.name}"/></td>
                                            <td><c:out value="${sector.detail}"/></td>
                                            <td><a href="customers?action=edit&id=${sector.id}">Editar</a></td>
                                            <td><a href="customers?action=erase&id=${sector.id}">Eliminar</a></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <%@include file="/shared/footer.jsp"%>


    </div>
</div>


</body>

<%@include file="/shared/js.jsp"%>


</html>