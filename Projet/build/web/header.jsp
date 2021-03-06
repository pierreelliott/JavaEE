<!-- NAVBAR -->
<nav class="navbar navbar-static-top navbar-inverse">
    <ul class="nav navbar-nav">
        <li><a href="accueil" id="active">Accueil</a></li>
        <li><a href="carte">Carte</a></li>
    </ul>

    <ul class="nav navbar-nav navbar-right">
        <c:choose>
            <c:when test="${ !empty sessionScope.utilisateur }">
                <!-- Si l'utilisateur est connect� -->
                <li class="dropdown">
                    <a data-toggle="dropdown" href="#"><c:out value="${ sessionScope.utilisateur.pseudo }"/><b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="utilisateur">Mon compte</a></li>
                        <li><a href="panier">Mon panier</a></li>
                        <li><a href="commande">Mes commandes</a></li>
                        <li class="divider"></li>
                        <li><a href="connexion">D�connexion</a></li>
                    </ul>
                </li>
            </c:when>
            <c:otherwise>
                <!-- Si l'utilisateur n'est pas connect� -->
                <li><a href="connexion">Connexion</a></li>
            </c:otherwise>
        </c:choose>
        

        <li><a href="panier"><span class="glyphicon glyphicon-shopping-cart"></a></li>
    </ul>
</nav>
<!-- NAVBAR END -->