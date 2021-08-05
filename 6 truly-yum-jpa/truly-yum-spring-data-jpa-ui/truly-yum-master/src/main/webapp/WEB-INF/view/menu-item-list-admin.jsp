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
      <span class="header-title">truYum</span>
      <img class="header-logo" src="truyum-logo-light.png" />
    </div>
    <nav>
      <a href="show-menu-list-admin" class="nav-menu">Menu</a>
    </nav>
  </header>

  <main>
    <input type="hidden" id="page" value="admin">
    <table>
      <caption>
        Menu Items
      </caption>
      <thead>
        <tr>
            <th style="text-align: left">Name</th>
            <th style="text-align: right">Price</th>
            <th style="text-align: center">Active</th>
            <th style="text-align: center">Date Of Launch</th>
            <th style="text-align: center">Category</th>
            <th style="text-align: center">Free Delivery</th>
            <th style="text-align: center">Action</th>
        </tr>
      </thead>
      <tbody id="admin-table">
        	<c:forEach items="${menuItemList}" var="menuItem">
					<tr>
						<td>${menuItem.name}</td>
						<td>${ menuItem.price }</td>
						<td>${ menuItem.active }</td>
						<td>${ menuItem.dateOfLaunch }</td>
						<td>${ menuItem.category }</td>
						<td>${ menuItem.freeDelivery }</td>
						<td><a href="show-edit-menu-item?menuItemId=${menuItem.id}">Edit</a></td>
					</tr>
				</c:forEach>
      </tbody>
      
    </table>
  </main>
  <footer>
    <div class="footer-text">
      Copyright &copy;&nbsp;<script>document.write(new Date().getFullYear())</script>
    </div>
  </footer>
  <script src="script.js"></script>
</body>
</html>