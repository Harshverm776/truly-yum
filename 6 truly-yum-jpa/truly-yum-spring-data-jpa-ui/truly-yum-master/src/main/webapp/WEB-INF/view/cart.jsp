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
			<a href="/show-menu-list-customer" class="nav-menu">Menu</a> 
			<a href="/show-cart" class="nav-cart">Cart</a>
		</nav>
	</header>
	<main>
		<table>
			<caption>
			Cart
			<c:if test="${removeCartItemStatus}">
				<p class="notification">Item removed from Cart successfully</p>
			</c:if>
			</caption>
			<thead>
				<tr>
					<th style="text-align: left">Name</th>
					<th style="text-align: center">Free Delivery</th>
					<th style="text-align: right">Price</th>
					<th style="text-align: center"></th>
				</tr>
			</thead>
			<tbody id="cart-table">
				<c:forEach items="${ cart.menuItemList }" var="menuItem">
					<tr>
						<td>${ menuItem.name }</td>
						<td>${ menuItem.freeDelivery }</td>
						<td>Rs. ${ menuItem.price }</td>
						<td><a href="/remove-cart-item?menuItemId=${ menuItem.id }">Delete</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td></td>
					<td>Total</td>
					<td>Rs. ${ cart.total }</td>
					<td></td>
				</tr>
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
</body>
</html>