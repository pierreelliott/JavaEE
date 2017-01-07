<?php
	session_start();
	/* Son but rediriger en fonction de la page où l'on se trouve vers le bon controleur */


	# On crée un formulaire invisible pour demander l'appel d'une page
	/*if(isset($_POST["page"])) $page = $_POST["page"];
	else $page = "accueil";*/
	# Pas utilisé mais je le laisse ici parce que je pense que ça pourrait être intéressant de le mettre en place

	if(isset($_POST["page"]))
	{
		$page = $_POST["page"];
	}
	else
	{
		$page = "accueil";
	}

	# Inclusion des différents contrôleurs
	include_once("carteControleur.php");
	include_once("connexionControleur.php");
	include_once("controleurUtilisateur.php");
	//include_once("controleurAdministration.php");
	include_once("deconnexionControleur.php");
	include_once("inscriptionControleur.php");
	include_once("panierControleur.php");

	# Instanciation des contrôleurs
	$carte = new carteControleur();
	$connexion = new connexionControleur();
	$utilisateur = new controleurUtilisateur();
	$inscription = new inscriptionControleur();
	$panier = new panierControleur();


	switch($page)
	{
		case "carte":
			$carte->carte();
			break;

		case "produit":
			if(isset($_GET["produit"])) $carte->afficherProduit($_GET["produit"]);
			else include_once("vue/404.php");
			break;

		case "connexion":
			$connexion->connexion();
			break;

		case "utilisateur":
			$utilisateur->afficherInfos();
			break;

		case "deconnexion":
			deconnexion();
			break;

		case "inscription":
			$statut = $inscription->inscription();
			if($statut)	$connexion->connexion();
			break;

		case "panier":
			$panier->afficherPanier();
			break;

		case "accueil":
			include_once("vue/accueil.php");
			break;

		case "administration":
		default:
			include_once("vue/404.php");
			break;
	}
?>
