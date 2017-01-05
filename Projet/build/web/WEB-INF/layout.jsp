<%-- 
    Document   : layout
    Created on : 5 janv. 2017, 17:10:11
    Author     : Pierre-Elliott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="sushis en ligne restauration rapide emporter livraison">
		<meta name="author" content="Pierre-Elliott Thiboud - Axel BERTRAND - Thomas BROUTIER">
		<link rel="icon" href="images/logo_onglet.png">
                <%! String contenu = (String)request.getParameter("contenu");
                    String titre = (String)request.getParameter("titre");
                    String incFile = (String)request.getParameter("includeFile");
                %>

		<title><% out.println(titre); %></title>

		<% //require("bootstrapCss.php"); %>

	</head>

	<body>
		<% //require("header.php"); %>

		<div class="container-fluid">
                        <% 
                        if(request.getParameter("hasParameter") != null)
                        {
                            out.print("<jsp:include page='"+incFile+"'>");
                            for(int i=0; i<1; i++)
                            {
                            out.print("<jsp:params></jsp:params>");
                            }
                            out.print("</jsp:include>");
                        }
                        else
                        {
                        out.print("<jsp:include page='"+incFile+"'/>");
                        }%>
		</div>


		<% //require("footer.php"); %>
	</body>
</html>
