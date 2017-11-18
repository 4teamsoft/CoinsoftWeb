<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 13/11/2017
  Time: 01:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
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
                    <a class="navbar-brand" href="#">Cliente/Nuevo</a>
                </div>
                <div class="collapse navbar-collapse">

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <p>
                                    {Usuario}
                                    <b class="caret"></b>
                                </p>

                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action 1</a></li>
                                <li><a href="#">Action 2</a></li>
                                <li><a href="#">Action 3</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Mas</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">
                                <p>Salir</p>
                            </a>
                        </li>
                        <li class="separator hidden-lg hidden-md"></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-9">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Datos del Cliente</h4>
                            </div>
                            <div class="content">
                                <form action="customers" method="post">
                                    <fieldset>
                                        <input type="hidden" name="action" value="create"/>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <div class="form-group">
                                                    <label>Codigo</label>
                                                    <input class="form-control" placeholder="Ejm: C10001" name="code" value="${customer.code}" type="text">
                                                </div>
                                            </div>
                                            <div class="col-md-5">
                                                <div class="form-group">
                                                    <label>DNI</label>
                                                    <input class="form-control" name="dni" value="${customer.dni}" type="text">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Nombres</label>
                                                    <input class="form-control" type="text" name="name" value="${customer.name}">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Apellidos</label>
                                                    <input class="form-control" type="text" name="lastName" value="${customer.lastName}">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Edad</label>
                                                    <input class="form-control" type="text" name="age" value="${customer.age}">
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label>Correo</label>
                                                    <input class="form-control" type="text" name="mail" value="${customer.mail}">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Tipo</label>
                                                    <select name="type" class="form-control" name="type" value="${customer.type}">
                                                        <option value="0">Puntual</option>
                                                        <option value="1">Moroso</option>
                                                        <option value="2">Mal Pagador</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-info btn-fill pull-right">Crear Nuevo Cliente</button>
                                        <div class="clearfix"></div>
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!--
                    <form action="customers" method="post">
                        <fieldset>
                            <input type="hidden" name="action" value="create"/>


                            <label for="name">Nombre</label>
                            <input type="text" name="name" id="name" value="${customer.name}"/>

                            <label for="type">Tipo</label>
                            <input type="text" name="type" id="type" value="${customer.type}"/>

                            <input type="submit"/>

                        </fieldset>
                    </form>-->
                </div>
            </div>
        </div>

        <%@include file="/shared/footer.jsp"%>


    </div>
</div>


</body>

<%@include file="/shared/js.jsp"%>


</html>