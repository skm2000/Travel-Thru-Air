<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Flight Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand">
					Flight Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Flights</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Flights</h3>
			<hr>
			<div class="container text-left">
			

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Flight</a>
					<a href="<%=request.getContextPath()%>/search" class="btn btn-success">Search
					Flights</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Flight ID</th>
						<th>Flight Name</th>
						<th>Dept Time</th>
						<th>Arr Time</th>
						<th>Legs</th>
						<th>Price</th>
						<th>Offer Available</th>
						<th>Dept City</th>
						<th>Arrival City</th>
						<th>Offer Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="flight" items="${listFlights}">
						<%
						System.out.println(pageContext.findAttribute("flight"));
						String check = request.getQueryString();
						System.out.println("check " + check);
						%>
						
						<tr>
						    <td><c:out value="${flight.flightId}" /></td>
							<td><c:out value="${flight.flightName}" /></td>
							<td><c:out value="${flight.deptTime}" /></td>
							<td><c:out value="${flight.arrivalTime}" /></td>
							<td><c:out value="${flight.totalLegs}" /></td>
							<td><c:out value="${flight.flightPrice}" /></td>
							<td><c:out value="${flight.isOffer}" /></td>
							<td><c:out value="${flight.deptCity}" /></td>
							<td><c:out value="${flight.arrCity}" /></td>
							<td><c:out value="${flight.offerPrice}"/></td>
							<td><a href="edit?id=<c:out value='${flight.flightId}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${flight.flightId}' />">Delete</a></td>
							
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>

</html>