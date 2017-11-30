<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 13/11/2017
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<ul class="nav navbar-nav navbar-right">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">


            <%
                String user = null;
                user = (String) session.getAttribute("user");
            %>

            <p>
                <%=user %>
                <b class="caret"></b>
            </p>


        </a>
        <ul class="dropdown-menu">
            <li><a href="#">Mi Perfil</a></li>
            <li><a href="#">Configuraciones</a></li>
            <li><a href="#">Mi estado</a></li>
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