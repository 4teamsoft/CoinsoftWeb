<%--
  Created by IntelliJ IDEA.
  User: J0hns
  Date: 13/11/2017
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<div class="sidebar" data-color="orange" data-image="img/sidebar-4.jpg">
    <div class="sidebar-wrapper">
        <div class="logo">
            <a href="http://www.creative-tim.com" class="simple-text">
                COINSOFT
            </a>
        </div>

        <ul class="nav">
            <li>
                <a href="dashboard.jsp">
                    <i class="fa fa-home" aria-hidden="true"></i>
                    <p>Inicio</p>
                </a>
            </li>



            <%
                int value = (Integer)session.getAttribute("type");
                if (value == 0) { %>
                    <li>
                        <a href="user.html">
                            <i class="fa fa-handshake-o" aria-hidden="true"></i>
                            <p>Asignacion</p>
                        </a>
                    </li>
            <% } %>

            <li>
                <a href="customers?action=list">
                    <i class="fa fa-user" aria-hidden="true"></i>
                    <p>Clientes</p>
                </a>
            </li>

            <% if (value == 0) { %>
            <li>
                <a href="employees?action=list">
                    <i class="fa fa-user-circle-o" aria-hidden="true"></i>
                    <p>Gestores</p>
                </a>
            </li>
            <li>
                <a href="typography.html">
                    <i class="fa fa-bar-chart" aria-hidden="true"></i>
                    <p>Reportes</p>
                </a>   &variable2=valor
            </li>
            <% } %>
            <li>
                <a href="customers?action=portfolio">
                    <i class="fa fa-briefcase" aria-hidden="true"></i>
                    <p>Carteras</p>
                </a>
            </li>
            <li>
                <a href="maps.html">
                    <i class="fa fa-key" aria-hidden="true"></i>
                    <p>Seguridad</p>
                </a>
            </li>
            <li>
                <a href="notifications.html">
                    <i class="fa fa-retweet" aria-hidden="true"></i>
                    <p>Transaccion</p>
                </a>
            </li>
        </ul>
    </div>
</div>