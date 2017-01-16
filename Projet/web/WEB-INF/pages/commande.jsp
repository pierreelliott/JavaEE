<%-- 
    Document   : commande
    Created on : 14 janv. 2017, 08:56:03
    Author     : Pierre-Elliott
--%>
<%@page pageEncoding="UTF-8" %>
<!-- ======== Début Code HTML ======== -->

<div class="row">
    <div class="col-lg-offset-3 col-lg-6 site-wrapper">
        <div class="row">
            <c:forEach items="${requestScope.commandes}"  var="commande">
                <div class="media">
                    <div class="media-left">
                        <h1>Commande n°<c:out value="${commande.numCommande}"/></h1>
                    </div>
                    <div class="media-body">
                        <p class="lead pull-left">Nombre de produits : <c:out value="${commande.nbProduits}"/></p>
                        <p class="lead">Prix de la commande : <c:out value="${commande.prix}"/> &euro;</p>
                        <c:forEach items="${commande.produits}"  var="produit">
                            <div class="row">
                                <p>Coucou</p>
                                <div class="panel panel-default">
                                    <div class="media">
                                        <div class="media-left">
                                            <img src="${produit.image}" alt="img produit">
                                        </div>
                                        <div class="media-body">
                                            <h1 class="media-heading text-muted">${produit.libelle}</h1>
                                            <p class="text-muted pull-left">${produit.description}</p>
                                            <p class="text-muted">prix : ${produit.prix} &euro;</p>
                                            <p class="text-muted">quantité : ${produit.quantite}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <hr/>
            </c:forEach>
        </div>
    </div>
</div>

<!-- ======== Fin Code HTML ======== -->