<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Flight Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand"> Flight Management App </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Flights</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                    <%
						System.out.println(pageContext.findAttribute("flight"));
						%>
                        <c:if test="${flight != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${flight == null}">
                            <form action="insert" method="post">
                        </c:if>
                        <caption>
                        
                            <h2>
                                <c:if test="${flight != null}">
                                    Edit Flight
                                </c:if>
                                <c:if test="${flight == null}">
                                    Add New Flight
                                </c:if>
                            </h2>
                        </caption>
                        <c:if test="${flight != null}">
                            <input type="hidden" name="flightId" value="<c:out value='${flight.flightId}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Flight Name</label> <input type="text" value="<c:out value='${flight.flightName}' />" class="form-control" name="FlightName" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Dept Time</label> <input type="text" value="<c:out value='${flight.deptTime}' />" class="form-control" name="DepTime" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Arrival Time</label> <input type="text" value="<c:out value='${flight.arrivalTime}' />" class="form-control" name="ArrTime" required="required" >
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Legs</label> <input type="text" value="<c:out value='${flight.totalLegs}' />" class="form-control" name="Legs" required="required">
                        </fieldset>
                        
                         <fieldset class="form-group">
                            <label>Price</label> <input type="text" value="<c:out value='${flight.flightPrice}' />" class="form-control" name="Price" required="required">
                        </fieldset>
                         
                         <fieldset class="form-group">
                            <label>Is Offer</label> <input type="text" value="<c:out value='${flight.isOffer}' />" class="form-control" name="IsOffer" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Dept City</label> <input type="text" value="<c:out value='${flight.deptCity}' />" class="form-control" name="DeptCity" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Arr City</label> <input type="text" value="<c:out value='${flight.arrCity}' />" class="form-control" name="ArrCity" required="required">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Offer Price</label> <input type="text" value="<c:out value='${flight.offerPrice}' />" class="form-control" name="OfferPrice" required="required">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>