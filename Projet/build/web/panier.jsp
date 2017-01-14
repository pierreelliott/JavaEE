

<!-- ======== Début Code HTML ======== -->
<c:choose>
    <c:when test="true">
<!-- Panier vide -->
    
	<div class="row">
            <div class="col-lg-offset-3 col-lg-6 site-wrapper">
                <p>Votre panier est vide</p>
            </div>
	</div>

<!-- ======== Fin Code HTML ======== -->
    </c:when>
    <c:otherwise>
<!-- ======== Début Code HTML ======== -->
<!-- Nouvel affichage -->
	<div class="row">
            <div class="col-lg-offset-3 col-lg-6 site-wrapper">
                <div>
                    <legend>Votre panier</legend>
                    <div class="row">
                        <c:forEach items="${ requestScope.panier }" var="produit">
                            <div class="col-xs-12 produit">
                                <div class="row">
                                    <div class="col-xs-2">
                                        <img src="${ produit.source }" alt="Image ${ produit.libelle }" class="img-responsive">
                                    </div>
                                    <div class="col-xs-3">
                                        <p>${ produit.libelle }</p>
                                    </div>
                                    <div class="col-xs-1">
                                        <button type="button" data-action="modification" data-produit="${ produit.numProduit }" data-qte="1" class="btn btn-xs btn-primary btn-qte-produit">+</button>
                                    </div>
                                    <div class="col-xs-1">
                                        <p>${ produit.quantite }</p>
                                    </div>
                                    <div class="col-xs-1">
                                        <button type="button" data-action="modification" data-produit="${ produit.numProduit }" data-qte="-1" class="btn btn-xs btn-primary btn-qte-produit">-</button>
                                    </div>
                                    <div class="col-xs-3">
                                        <p>${ produit.prix } ?</p>
                                    </div>
                                    <div class="col-xs-1">
                                        <button type="button" data-action="suppression" data-produit="${ produit.numProduit }" class="btn btn-xs btn-danger btn-qte-produit">&times;</button>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="row">
                        <p>Prix du panier : 0 ?</p>
                    </div>
                </div>
            </div>
	</div>
    </c:otherwise>
</c:choose>
<!-- ======== Fin Code HTML ======== -->

<!-- ======== Début Code Javascript ======== -->
<script>
    $(function()
    {
        $('button').click(function(e) {
            console.log('test');
            var produit = $(this).data('produit');
            var action = $(this).data('action');
            var qte = $(this).data('qte');
            $.post('index.php',
            {
                page: 'panier',
                action: action,
                produit: produit,
                qte: qte
            },
            function(data, status)
            {
                // Faire une popup pour indiquer que le produit à bien été ajouté
                location.reload(true);
                console.log('Data : ' + data + ', Status : ' + status);
            });
        });
    });
</script>
<!-- ======== Fin Code Javascript ======== -->