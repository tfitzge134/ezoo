
<!-- Header -->
<%@page import="com.feeding_schedules.model.FeedingSchedule"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- JSTL includes -->

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

		<h1>
			eZoo <small>View All Feeding Schedule</small>
		</h1>
		<hr class="paw-primary">

		<c:choose>
			<c:when test="${empty allFeedingSchedules }">
				<p>No records found.</p>
				
			</c:when>
		</c:choose>
		
		<c:choose>
		<c:when test="${not empty allFeedingSchedules }">
		<div>
			<table border="1">
				<tr border="1">
					<th>Schedule ID</th>
					<th>Feeding Time</th>
					<th>Recurrence</th>
					<th>Food</th>
					<th>Notes</th>
					<th>Animal ID</th>
					<th>Update</th>
					<th>Delete</th>
				</tr>
				<c:forEach items="${allFeedingSchedules}" var="fs">
					<tr background="black">
						<td>${fs.schedule_id}</td>
						<td>${fs.feeding_time}</td>
						<td>${fs.recurrence}</td>
						<td>${fs.food}</td>
						<td>${fs.notes}</td>
						<td>${fs.animalID}</td>
						<td><a href="updateFeedingSchedule?schedule_id=${fs.schedule_id}&animalID=${fs.animalID}">Update</a></td>
						<td><a href="removeFeedingSchedule?schedule_id=${fs.schedule_id}&animalID=${fs.animalID}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>


		</div>
		</c:when>
		</c:choose>





	</div>
</header>


<!-- Footer -->
<jsp:include page="footer.jsp" />