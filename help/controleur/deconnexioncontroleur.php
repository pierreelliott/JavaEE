<?php
	
	function deconnexion()
	{
		// Suppression des variables de session et de la session
		$_SESSION = array();
		session_destroy();

		// Suppression des cookies de connexion automatique
		setcookie("pseudo", "");
		setcookie("mdpHash", "");

		header("Location: index.php");
	}
    