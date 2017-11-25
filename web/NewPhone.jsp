<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Coinsoft</title>
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
                    <a class="navbar-brand" href="#">Nuevo Numero</a>
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
                                <h4 class="title">Datos del Telefono del Cliente</h4>
                            </div>
                            <div class="content">
                                <form action="customer" method="post">
                                    <fieldset>
                                        <input type="hidden" name="action" value="create"/>
                                        <div class="row">
                                            <div class="col-md-5">
                                                <div class="form-group">
                                                    <label>Numero</label>
                                                    <input class="form-control" placeholder="Ejm: 997673234 o 7662832" name="number" value="${phone.number}" type="number">
                                                </div>
                                            </div>
                                            <div class="col-md-5">
                                                <div class="form-group">
                                                    <label>type</label>
                                                    <input class="form-control" name="dni" value="${phone.number}" type="text">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="row">
                                           <div class="col-md-3">
                                               <div class="form-group">
                                                   <label>Tipo</label>
                                                   <select name="type" class="form-control" value="${phone.type}">
                                                       <option selected>Seleccione una opcion</option>
                                                       <option value="1">Celular</option>
                                                       <option value="2">Fijo</option>
                                                   </select>
                                               </div>
                                           </div>
                                       </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-3">
                                                <div class="form-group">
                                                    <label>Seleccione Operador</label>
                                                    <select name="operator" class="form-control" value="${phone.operator}">
                                                        <option selected>Seleccione una opcion</option>
                                                        <option value="1">Movistar</option>
                                                        <option value="2">Claro</option>
                                                        <option value="3">Entel</option>
                                                        <option value="4">Bitel</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <button type="submit" class="btn btn-info btn-fill pull-right">Registrar Telefono</button>
                                        <div class="clearfix"></div>
                                    </fieldset>
                                </form>
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
