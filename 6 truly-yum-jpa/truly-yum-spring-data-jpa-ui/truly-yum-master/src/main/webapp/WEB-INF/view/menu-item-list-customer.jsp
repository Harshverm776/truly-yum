<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>TruYum</title>
</head>
<body>
	<header>
		<div class="header-left">
			<span class="header-title">truYum</span> <img class="header-logo"
				src="truyum-logo-light.png" />
		</div>
		<nav>
			<a href="/show-menu-list-customer" class="nav-menu">Menu</a> <a
				href="/show-cart" class="nav-cart">Cart</a>
		</nav>
	</header>

	<main>
		<input type="hidden" id="page" value="customer">
		<table>
			<caption>
			Menu Items
			<c:if test="${addCartStatus}">
				<p class="notification">Item added to Cart successfully</p>
			</c:if>
			</caption>
			<thead>
				<tr>
					<th style="text-align: left">Name</th>
					<th style="text-align: center">Free Delivery</th>
					<th style="text-align: right">Price</th>
					<th style="text-align: center">Category</th>
					<th style="text-align: center">Action</th>
				</tr>
			</thead>
			<tbody id="customer-table">
				<c:forEach items="${menuItemList}" var="menuItem">
					<tr>
						<td>${menuItem.name}</td>
						<td>${ menuItem.freeDelivery }</td>
						<td>${ menuItem.price }</td>
						<td>${ menuItem.category }</td>
						<td><a href="/add-to-cart?menuItemId=${menuItem.id}">Add
								to Cart</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<footer>
		<div class="footer-text">
			Copyright &copy;&nbsp;
			<script>
				document.write(new Date().getFullYear())
			</script>
		</div>
	</footer>
	<script src="./js/script.js"></script>
</body>
</html>