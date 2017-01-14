<%-- 
    Document   : commande
    Created on : 14 janv. 2017, 08:56:03
    Author     : Pierre-Elliott
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- ======== Début Code HTML ======== -->

<div class="row">
    <div class="col-lg-offset-3 col-lg-6 site-wrapper">
        <div class="row">
            <c:forEach items="${requestScope.commandes}"  var="commande">
                <div class="media">
                    <div class="media-left">
                        <h1>Commande du <c:out value="${commande.date}"/></h1>
                    </div>
                    <div class="media-body">
                        <p class="lead">Nombre de produits : <c:out value="${$commande.nbProduits}"/> €</p>
                        <p class="lead">Prix de la commande : <c:out value="${commande.prix}"/> €</p>
                    </div>
                </div>
            </c:forEach>>
        </div>
    </div>
</div>

<!-- ======== Fin Code HTML ======== -->