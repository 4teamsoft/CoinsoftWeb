<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 18/11/2017
  Time: 00:58
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

    <%@include file="/shared/sidebarForEmploye.jsp"%>

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
                    <a class="navbar-brand" href="#">Panel de Informacion</a>
                </div>
                <div class="collapse navbar-collapse">

                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <p>
                                    <c:out value="${employe.name}" />
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

                    <div class="col-md-4">
                        <div class="card">

                            <div class="header">
                                <h4 class="title">Estadisticas Generales</h4>
                                <p class="category">Conteo actual disponible</p>
                            </div>
                            <div class="content">

                                <i class="fa fa-user-circle-o" aria-hidden="true"></i> Gestores Disponibles <b>(Sin contar)</b><br>
                                <i class="fa fa-user" aria-hidden="true"></i> Clientes Actuales <b>(<c:out value="${countCustomers}"/>)</b><br>
                                <i class="fa fa-usd" aria-hidden="true"></i> Prestamos Activos <b>(3)</b><br>

                            </div>
                        </div>
                    </div>

                    <!--
                                        <div class="col-md-8">
                                            <div class="card">
                                                <div class="header">
                                                    <h4 class="title">Users Behavior</h4>
                                                    <p class="category">24 Hours performance</p>
                                                </div>
                                                <div class="content">
                                                    <div id="chartHours" class="ct-chart"><svg xmlns:ct="http://gionkunz.github.com/chartist-js/ct" width="100%" height="245px" class="ct-chart-line" style="width: 100%; height: 245px;"><g class="ct-grids"><line y1="210" y2="210" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line><line y1="185.625" y2="185.625" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line><line y1="161.25" y2="161.25" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line><line y1="136.875" y2="136.875" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line><line y1="112.5" y2="112.5" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line><line y1="88.125" y2="88.125" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line><line y1="63.75" y2="63.75" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line><line y1="39.375" y2="39.375" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line><line y1="15" y2="15" x1="50" x2="744.4666748046875" class="ct-grid ct-vertical"></line></g><g><g class="ct-series ct-series-a"><path d="M50,210L50,140.044C69.291,140.044,88.581,116.156,107.872,116.156C127.163,116.156,146.454,90.563,165.744,90.563C185.035,90.563,204.326,90.075,223.617,90.075C242.907,90.075,262.198,74.963,281.489,74.963C300.78,74.963,320.07,67.163,339.361,67.163C358.652,67.163,377.943,39.863,397.233,39.863C416.524,39.863,435.815,40.594,455.106,40.594C474.396,40.594,493.687,26.7,512.978,26.7C532.269,26.7,551.559,17.925,570.85,17.925C590.141,17.925,609.431,3.787,628.722,3.787C648.013,3.787,667.304,-20.1,686.594,-20.1L686.594,210Z" class="ct-area"></path></g><g class="ct-series ct-series-b"><path d="M50,210L50,193.669C69.291,193.669,88.581,172.95,107.872,172.95C127.163,172.95,146.454,175.144,165.744,175.144C185.035,175.144,204.326,151.5,223.617,151.5C242.907,151.5,262.198,140.044,281.489,140.044C300.78,140.044,320.07,128.344,339.361,128.344C358.652,128.344,377.943,103.969,397.233,103.969C416.524,103.969,435.815,103.481,455.106,103.481C474.396,103.481,493.687,78.619,512.978,78.619C532.269,78.619,551.559,77.887,570.85,77.887C590.141,77.887,609.431,77.4,628.722,77.4C648.013,77.4,667.304,52.294,686.594,52.294L686.594,210Z" class="ct-area"></path></g><g class="ct-series ct-series-c"><path d="M50,210L50,204.394C69.291,204.394,88.581,182.456,107.872,182.456C127.163,182.456,146.454,193.669,165.744,193.669C185.035,193.669,204.326,183.675,223.617,183.675C242.907,183.675,262.198,163.688,281.489,163.688C300.78,163.688,320.07,151.744,339.361,151.744C358.652,151.744,377.943,135.169,397.233,135.169C416.524,135.169,435.815,134.925,455.106,134.925C474.396,134.925,493.687,102.994,512.978,102.994C532.269,102.994,551.559,110.063,570.85,110.063C590.141,110.063,609.431,110.063,628.722,110.063C648.013,110.063,667.304,85.931,686.594,85.931L686.594,210Z" class="ct-area"></path></g></g><g class="ct-labels"><foreignObject style="overflow: visible;" x="50" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;">9:00AM</span></foreignObject><foreignObject style="overflow: visible;" x="107.87222290039062" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;">12:00AM</span></foreignObject><foreignObject style="overflow: visible;" x="165.74444580078125" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;">3:00PM</span></foreignObject><foreignObject style="overflow: visible;" x="223.61666870117188" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;">6:00PM</span></foreignObject><foreignObject style="overflow: visible;" x="281.4888916015625" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;">9:00PM</span></foreignObject><foreignObject style="overflow: visible;" x="339.3611145019531" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;">12:00PM</span></foreignObject><foreignObject style="overflow: visible;" x="397.23333740234375" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;">3:00AM</span></foreignObject><foreignObject style="overflow: visible;" x="455.1055603027344" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;">6:00AM</span></foreignObject><foreignObject style="overflow: visible;" x="512.977783203125" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;"></span></foreignObject><foreignObject style="overflow: visible;" x="570.8500061035156" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;"></span></foreignObject><foreignObject style="overflow: visible;" x="628.7222290039062" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;"></span></foreignObject><foreignObject style="overflow: visible;" x="686.5944519042969" y="215" width="57.872222900390625" height="20"><span class="ct-label ct-horizontal ct-end" xmlns="http://www.w3.org/2000/xmlns/" style="width: 58px; height: 20px;"></span></foreignObject><foreignObject style="overflow: visible;" y="185.625" x="10" height="24.375" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 24px; width: 30px;">0</span></foreignObject><foreignObject style="overflow: visible;" y="161.25" x="10" height="24.375" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 24px; width: 30px;">100</span></foreignObject><foreignObject style="overflow: visible;" y="136.875" x="10" height="24.375" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 24px; width: 30px;">200</span></foreignObject><foreignObject style="overflow: visible;" y="112.5" x="10" height="24.375" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 24px; width: 30px;">300</span></foreignObject><foreignObject style="overflow: visible;" y="88.125" x="10" height="24.375" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 24px; width: 30px;">400</span></foreignObject><foreignObject style="overflow: visible;" y="63.75" x="10" height="24.375" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 24px; width: 30px;">500</span></foreignObject><foreignObject style="overflow: visible;" y="39.375" x="10" height="24.375" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 24px; width: 30px;">600</span></foreignObject><foreignObject style="overflow: visible;" y="15" x="10" height="24.375" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 24px; width: 30px;">700</span></foreignObject><foreignObject style="overflow: visible;" y="-15" x="10" height="30" width="30"><span class="ct-label ct-vertical ct-start" xmlns="http://www.w3.org/2000/xmlns/" style="height: 30px; width: 30px;">800</span></foreignObject></g></svg></div>
                                                    <div class="footer">
                                                        <div class="legend">
                                                            <i class="fa fa-circle text-info"></i> Open
                                                            <i class="fa fa-circle text-danger"></i> Click
                                                            <i class="fa fa-circle text-warning"></i> Click Second Time
                                                        </div>
                                                        <hr>
                                                        <div class="stats">
                                                            <i class="fa fa-history"></i> Updated 3 minutes ago
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div> -->

                </div>
            </div>
        </div>

        <%@include file="/shared/footer.jsp"%>


    </div>
</div>


</body>

<%@include file="/shared/js.jsp"%>


</html>
