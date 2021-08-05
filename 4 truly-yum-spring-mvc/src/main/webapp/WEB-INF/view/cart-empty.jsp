<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<div class="page-layout">
			<div class="caption">Cart</div>
			<div class="status">
				<p class="cart-empty">
					No items in cart. Use 'Add to Cart' option in <a
						href="/show-menu-list-customer">Menu Item List</a>.
				</p>
			</div>
		</div>
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