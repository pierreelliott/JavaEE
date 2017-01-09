<%-- 
    Document   : layout
    Created on : 5 janv. 2017, 17:10:11
    Author     : Pierre-Elliott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:tiles="http://tiles.apache.org/tags-tiles">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="sushis en ligne restauration rapide emporter livraison">
		<meta name="author" content="Pierre-Elliott THIBOUD - Axel BERTRAND - Thomas BROUTIER">
		<link rel="icon" href="images/logo_onglet.png">

		<title>Coucou</title>

                <%@ include file="jspf/bootstrapCss.jspf" %>
	</head>

	<body>
                <jsp:include page="jspf/header.jspf" />

		<div class="container-fluid">
                    <tiles:insertAttribute name="accueil.jsp" />
                    Coucou
		</div>


                <jsp:include page="jspf/footer.jspf" />
                <jsp:include page="jspf/bootstrapJavascript.jspf" />
                <jsp:include page="jspf/appelPages.jspf" />
	</body>
</html>