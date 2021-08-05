<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
      <a href="/show-menu-list-admin" class="nav-menu">Menu</a>
    </nav>
  </header>

  <main>
    <div class="page-layout">
      <div class="caption">
        Edit Menu Item
      </div>
      <form:form name="menuItemForm" method="post" action="/edit-menu-item" modelAttribute="menuItem" class="menu-form">
      	<form:hidden path="id" />
        <div class="menu-form-column">
          <form:label path="name">Name</form:label>
          <form:input path="name" id="title"/>
          <form:errors path="name" />
        </div>
        <div class="menu-form-row">
          <div class="menu-form-column">
            <form:label path="price">Price (Rs.)</form:label>
            <form:input path="price" required="required"/>
            <form:errors path="price" />
          </div>
          <div class="menu-form-column">
            <form:label path="active">Active</form:label>
            <div>
              <form:radiobutton path="active" value="yes" />Yes
              <form:radiobutton path="active" value="no" />No
            </div>
          </div>
          <div class="menu-form-column">
            <form:label path="dateOfLaunch">Date of Launch</form:label>
            <form:input  id="dateOfLaunch" path="dateOfLaunch" required="required"/>
            <form:errors path="dateOfLaunch" />
          </div>
          <div class="menu-form-column">
            <form:label path="category">Category</form:label>
            <form:select path="category" id="category">
              <form:option value="Starters">Starters</form:option>
              <form:option value="Main Course">Main Course</form:option>
              <form:option value="Desert">Desert</form:option>
              <form:option value="Drinks">Drinks</form:option>
            </form:select>
          </div>
        </div>
        <div>
          <form:checkbox path="freeDelivery" id="freeDelivery" value="Free Delivery"/>
          <label for="freedelivery">Free Delivery</label>
        </div>
        <div>
          <form:button type="submit" name="submit" class="button" onClick="validateMenuItemForm()">Save</form:button>
        </div>
      </form:form>
    </div>
  </main>
  <footer>
    <div class="footer-text">
      Copyright &copy;&nbsp;<script>document.write(new Date().getFullYear())</script>
    </div>
  </footer>
</body>
</html>