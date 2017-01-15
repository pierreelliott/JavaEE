<%-- 
    Document   : utilisateur
    Created on : 14 janv. 2017, 08:57:25
    Author     : Pierre-Elliott
--%>
<!-- ======== Début Code HTML ======== -->

<div class="row">
    <div class="col-lg-offset-3 col-lg-6 site-wrapper">
        <h1>Vos informations - ${sessionScope.utilisateur.nom} ${sessionScope.utilisateur.prenom}</h1>
        <dl>
            <dt><span class="glyphicon glyphicon-user"></span> Pseudo :</dt>
            <dd>${sessionScope.utilisateur.pseudo}</dd>
            <dt>@ Adresse mail :</dt>
            <dd>${sessionScope.utilisateur.mail}</dd>
            <dt><span class="glyphicon glyphicon glyphicon-phone"></span> Téléphone :</dt>
            <dd>${sessionScope.utilisateur.telephone}</dd>
            <dt><span class="glyphicon glyphicon-map-marker"></span> Adresse :</dt>
            <dd><c:choose>
                    <c:when test="${ requestScope.adresse }">
                        <c:out value="${sessionScope.utilisateur.numRue} ${sessionScope.utilisateur.rue} ${sessionScope.utilisateur.codePostal} ${sessionScope.utilisateur.ville}"/>
                    </c:when>
                    <c:otherwise>
                        Vous n'avez pas renseigné d'adresse
                    </c:otherwise>
                </c:choose>
            </dd>
            <dt><span class="glyphicon glyphicon-map-marker"></span> Date d'inscription :</dt>
            <dd>${sessionScope.utilisateur.dateInscription}</dd>
            <dt><span class="glyphicon glyphicon-map-marker"></span> Date de votre dernière connexion :</dt>
            <dd>${cookie.dateDerniereConnexion.value}</dd>
        </dl>
    </div>
</div>

<!-- ======== Fin Code HTML ======== -->