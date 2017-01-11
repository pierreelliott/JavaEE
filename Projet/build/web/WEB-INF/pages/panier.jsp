
	<% if(requestScope.estVide)
	{%>

<!-- ======== Début Code HTML ======== -->
<!-- Panier vide -->

	<div class="row">
		<div class="col-lg-offset-3 col-lg-6 site-wrapper">
			<p>Votre panier est vide</p>
		</div>
	</div>

<!-- ======== Fin Code HTML ======== -->
    <%
	}
	else {
    %>
<!-- ======== Début Code HTML ======== -->
<!-- Nouvel affichage -->
	<div class="row">
		<div class="col-lg-offset-3 col-lg-6 site-wrapper">
			<div>
				<legend>Votre panier</legend>
				<div class="row">
					<c:foreach items="${requestScope.panier}" var="produit">
					<!--<tr>
						<td><?php echo $produit["libelle"]; ?></td>
						<td><?php echo $produit["quantite"]; ?></td>
						<td><?php echo $produit["prix"]; ?></td>
						<td><?php echo $this->panier->getPrixTotalProduit($numProduit); ?></td>
						<td><a href='<?php echo 'index.php?page=panier&action=suppression&produit='.$numProduit.','.implode(',', $produit); ?>'><img src="images/mooins2.png" alt="Retirer du panier" title="Retirer du panier"/></a></td>
					</tr>-->
					<div class="col-xs-12 produit">
						<div class="row">
							<div class="col-xs-2">
								<img src="<?php echo $produit["source"]; ?>" alt="Image <?php echo $produit["libelle"]; ?>" class="img-responsive">
							</div>
							<div class="col-xs-3">
								<p><?php echo $produit["libelle"]; ?></p>
							</div>
							<div class="col-xs-1">
								<button type="button" data-action="modification" data-produit="<?php echo $numProduit.','.implode(',', $produit); ?>" data-qte="1" class="btn btn-xs btn-primary btn-qte-produit">+</button>
							</div>
							<div class="col-xs-1">
								<p><?php echo $produit["quantite"]; ?></p>
							</div>
							<div class="col-xs-1">
								<button type="button" data-action="modification" data-produit="<?php echo $numProduit.','.implode(',', $produit); ?>" data-qte="-1" class="btn btn-xs btn-primary btn-qte-produit">-</button>
							</div>
							<div class="col-xs-3">
								<p><?php echo $produit["prix"]; ?> ?</p>
							</div>
							<div class="col-xs-1">
								<button type="button" data-action="suppression" data-produit="<?php echo $numProduit.','.implode(',', $produit); ?>" class="btn btn-xs btn-danger btn-qte-produit">&times;</button>
							</div>
						</div>
					</div>
                                        </c:foreach>
				</div>
				<div class="row">
					<p>Prix du panier : <?php echo $this->panier->getPrixTotalProduit($numProduit); ?> ?</p>
				</div>
			</div>
		</div>
	</div>
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