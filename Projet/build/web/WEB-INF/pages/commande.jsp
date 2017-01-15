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
                        <p class="lead">Nombre de produits : <c:out value="${commande.nbProduits}"/> €</p>
                        <p class="lead">Prix de la commande : <c:out value="${commande.prix}"/> €</p>
                        <c:forEach items="${commande.prods}"  var="produit">
                            <div class="row">
                                <div class="panel panel-default">
                                    <div class="media">
                                        <div class="media-left">
                                            ${produit.image}
                                        </div>
                                        <div class="media-body">
                                            <h1 class="media-heading text-muted">${produit.libelle}</h1>
                                            <p class="muted pull-left">${produit.description}</p>
                                            <p class="muted pull-left">${produit.prix}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<!-- ======== Fin Code HTML ======== -->