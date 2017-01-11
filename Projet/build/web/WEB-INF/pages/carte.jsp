<%-- 
    Document   : carte
    Created on : 7 janv. 2017, 18:19:08
    Author     : Pierre-Elliott
--%>

<!-- ======== Début Code HTML ======== -->

	<div class="row">
            <div class="col-lg-offset-3 col-lg-6 site-wrapper">
                <table class="table table-hover">
                    <thead>
                        <tr>
                                <th>Produit</th>
                                <th>Description</th>
                                <th>Image</th>
                                <th>Ajout panier</th>
                        </tr>
                    </thead>
                    <c:forEach items="${ carte.produits }" var="produit">
                        <tr>
                            <td><a href="accueil?page=produit&produit=${ produit.numProduit }">
                                    ${ produit.libelle }</a></td>
                            <td>${ produit.description }</td>
                            <td><img src='${ produit.sourceMoyen }' alt='Image du produit'></td>
                            <td>
                                    <button type="button" data-action="ajout" data-produit="${ produit.numProduit },1" class="btn btn-primary">
                                            <img title='Ajouter au panier' alt='Ajouter au panier' src='images/achat2.png'>
                                    </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
	</div>

<!-- ======== Fin Code HTML ======== -->

<!-- ============ Script pour le panier ============= -->
<script>
    $(function()
    {
        $('button').click(function(e) {
            console.log('test');
            var produit = $(this).data('produit');
            var action = $(this).data('action');
            var qte = $(this).data('qte');
            $.post('accueil',
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
<!-- ============ Fin du script pour le panier ============= -->