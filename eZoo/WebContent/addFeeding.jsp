<jsp:include page="header.jsp" />
	
	<!-- JSTL includes -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	
<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">

	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
 
		<h1>eZoo <small>Feeding Schedule</small></h1>
		<hr class="paw-primary">
		<table class="table table-striped table-hover table-responsive ezoo-datatable">
			<thead>
				<tr>
					<th class="text-center">Animal ID</th>
					<th class="text-center">assigned</th>
						<th class="text-center">feeding_time</th>
						<th class = "text-center">food</th>
						<th class = "text-center">notes</th>
						<th class = "text-center">recurrence</th>
						<th class = "text-center">schedule_id</th>
						
<!-- 					<th class="text-center">Phylum</th>
					<th class="text-center">Class</th>
					<th class="text-center">Order</th>
					<th class="text-center">Family</th>
					<th class="text-center">Genus</th>
					<th class="text-center">Species</th>
					<th class="text-center">Height(ft)</th>
					<th class="text-center">Weight(lbs)</th>
					<th class="text-center">Type</th>
					<th class="text-center">Health Status</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach var="feedingSchedule" items="${feedingSchedule}">
					<tr>
						<td><c:out value="${feedingSchedule.animalid}" /></td>
						<td><c:out value="${feedingSchedule.feeding_time}" /></td>
						<td><c:out value="${feedingSchedule.food}" /></td>
						

						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>	

	  </div>
	</header>
	


	<!-- Footer -->
	<jsp:include page="footer.jsp" />
