<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<h1 class="bg-info text-white" style="text-align: center">Customer
			Relationship Management</h1>
		<hr />

		<h2>
			<c:out
				value="${newCustomer ? 'Add a new customer' : 'Update customer'}" />
		</h2>

		<form action="/CustomerManagement/customers/save" method="post">
			<div class="mb-3">
				<input type="hidden" class="form-control" name="id"
					value="${customer.id}">
			</div>

			<div class="form-inline">
				<input type="text" name="firstName" value="${customer.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>

			<div class="form-inline">
				<input type="text" name="lastName" value="${customer.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>

			<div class="form-inline">
				<input type="text" name="email" value="${customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>
			<a href="/CustomerManagement/customers/list" class="btn btn-danger">Cancel</a>
			
			<a href="/CustomerManagement/" class="btn btn-info">Back to Home</a>
		</form>
	</div>

</body>
</html>