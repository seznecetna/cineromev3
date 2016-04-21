<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<a href="ListDesArticles">Revenir � la liste des articles</a><br/>

<title>Mon panier</title>

<p> Voici la liste de votre panier : </p>

<c:forEach var="object_panier" items="${listePanier}">
			<tr>
				<td>${object_panier.prixHT}</td>
				<td>${object_panier.stock}</td>
				<td>${object_panier.designation}</td>
				<td>${object_panier.reference}</td>
				<td>${object_panier.realisateur}</td>
				<td>${object_panier.titre}</td>
				<td>${object_panier.auteur}</td>
				<td>${object_panier.editeur}</td>
				<td>${object_panier.genre}</td>
			</tr>
		</c:forEach>
<form action="PanierCineRomeV2Controller" method="POST">
<p>Valider votre panier </p>
<input type="submit" value= "validation" name="paniervalide"><br/>
</form>
</head>
<body>

</body>
</html>