<?php
    $title = "La carte";

    ob_start();
?>
<!-- ======== Début Code HTML ======== -->

	<div class="row">
		<div class="col-lg-offset-3 col-lg-6 site-wrapper">
			<table class="table table-hover">
				<tr>
					<th>Produit</th>
					<th>Description</th>
					<th>Image</th>
					<th>Ajout panier</th>
				</tr>
				<?php
					foreach($tabRows as $key => $row) {
				?>
				<tr>
					<td><a href="index.php?page=produit&produit=<?php echo $row["numProduit"]; ?>">
						<?php echo $row["libelle"]; ?></a></td>
					<td><?php echo $row["description"]; ?></td>
					<td><img src='<?php echo $row["sourceMoyen"]; ?>' alt='Image du produit'></td>
					<td>
						<a href='index.php?page=panier&action=ajout&produit=<?php echo implode(',', $row); ?>'>
							<img title='Ajouter au panier' alt='Ajouter au panier' src='images/achat2.png'>
						</a>
					</td>
				</tr>
				<?php
				}
				?>
			</table>
		</div>
	</div>

<!-- ======== Fin Code HTML ======== -->
<?php
	$contenu = ob_get_clean();

    require("layout/site.php");
?>
