<?php

	$title = "Mon panier";

	ob_start();
?>
<!-- ======== Début Code HTML ======== -->
	<div class="row">
		<div class="col-lg-offset-3 col-lg-6 site-wrapper">
			<div data-estVide="<?php echo $estVide; ?>" class="panier">
			<?php
			//Si le panier est vide
			if($estVide)
			{
				echo "Votre panier est vide";
			}
			else
			{
			?>
				<legend>Votre panier</legend>
				<div class="row">

					<?php foreach($produits as $numProduit => $produit) { ?>

					<div id="<?php echo $numProduit; ?>" class="col-xs-12 produit">
						<div class="row produit-ligne-separateurs">
							<div class="col-xs-2">
								<img src="<?php echo $produit["sourceMoyen"]; ?>" alt="Image <?php echo $produit["libelle"]; ?>" class="img-responsive">
							</div>
							<div class="col-xs-3">
								<p><?php echo $produit["libelle"]; ?></p>
							</div>
							<div class="col-xs-1"> <!-- Enlever une occurrence -->
								<button type="button" data-action="modification" data-produit="<?php echo $numProduit; ?>" data-qte="-1" class="btn btn-xs btn-primary btn-qte-produit">-</button>
							</div>
							<div class="col-xs-1">
								<p class="qte"><?php echo $produit["quantite"]; ?></p>
							</div>
							<div class="col-xs-1"> <!-- Ajouter une occurrence -->
								<button type="button" data-action="modification" data-produit="<?php echo $numProduit; ?>" data-qte="1" class="btn btn-xs btn-primary btn-qte-produit">+</button>
							</div>
							<div class="col-xs-3">
								<p><?php echo $produit["prix"]; ?> €</p>
							</div>
							<div class="col-xs-1">
								<button type="button" data-action="suppression" data-produit="<?php echo $numProduit; ?>" class="btn btn-xs btn-danger btn-qte-produit">&times;</button>
							</div>
						</div>
					</div>

					<?php } ?>

				</div>
				<div class="row">
					<p class="prix">Prix du panier : <?php echo $prixTotal; ?> €</p>
				</div>
			</div>

			<?php } ?>

		</div>
	</div>

<!-- ======== Fin Code HTML ======== -->
<?php

	$contenu = ob_get_clean();
?>
<!-- ======== Début Code Javascript ======== -->
<script>
    $(function()
    {
        $('button').click(function(e) {
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
								

								var panierVide = $(data).find('.panier').data('estVide');
								console.log('estVide : ' + panierVide);
								if(panierVide === "1")
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
<?php
  $script = ob_get_clean();

	require("layout/site.php");
?>
