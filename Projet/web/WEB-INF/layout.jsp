<%-- 
    Document   : layout
    Created on : 5 janv. 2017, 17:10:11
    Author     : Pierre-Elliott
--%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:tiles="http://tiles.apache.org/tags-tiles">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="sushis en ligne restauration rapide emporter livraison">
		<meta name="author" content="Pierre-Elliott THIBOUD - Axel BERTRAND - Thomas BROUTIER">
		<link rel="icon" href="images/logo_onglet.png">

		<title>Sushinos - ${requestScope.titrePage}</title>

                <jsp:include page="jspf/bootstrapCss.jspf" />
	</head>

	<body>
                <jsp:include page="pages/header.jsp" />

		<div class="container-fluid">
                    <jsp:include page="${requestScope.afficherPage}" />
		</div>


                <jsp:include page="jspf/footer.jspf" />
                <jsp:include page="jspf/bootstrapJavascript.jspf" />
                <jsp:include page="jspf/appelPages.jspf" />
	</body>
</html>