

<!-- ======== Début Code HTML ======== -->
<c:choose>
    <c:when test="${requestScope.panierVide}">
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
<script>
    $(function()
    {
        $('button').click(function(e)
        {
            var produit = $(this).data('produit');
            var action = $(this).data('action');
            var qte = $(this).data('qte');
            $.post('panier',
            {
                action: action,
                numProduit: produit,
                qte: qte
            },
            function(data, status)
            {
                // Faire une popup pour indiquer que le produit à bien été ajouté

                var panierVide = $(data).find('.panier').data('estVide');
                console.log('estVide : ' + panierVide);
                if (panierVide === "1")
                {
                    $('.panier').text('Votre panier est vide');
                }

                var qte = $(data).find('#' + produit + ' .qte').text();
                var prix = $(data).find('.prix').text();
                console.log('qte : ' + qte);
                console.log('prix : ' + prix);
                if(qte === "")
                {
                    $('#' + produit).remove();
                }
                else
                {
                    $('#' + produit + ' .qte').text(qte);
                }

                $('.prix').text(prix);
            });
        });
    });
</script>
<!-- ======== Fin Code Javascript ======== -->