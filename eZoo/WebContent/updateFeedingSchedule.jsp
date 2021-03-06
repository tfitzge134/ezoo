	<!-- Header -->
	<%@page import="com.feeding_schedules.model.FeedingSchedule"%>
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
	
	<%
	FeedingSchedule feedingSchedule =  (FeedingSchedule) request.getAttribute("feedingSchedule");
	%>
	
		<h1>eZoo <small>Update FeedingSchedule</small></h1>
		<hr class="paw-primary">
		
		<form action="updateFeedingSchedule" method="post" class="form-horizontal">
		
		<input type="hidden" name="schedule_id" value="${feedingSchedule.schedule_id}">
		<input type="hidden" name=animalID value="${feedingSchedule.animalID}">
		
		  <div class="form-group">
		    <label for="id" class="col-sm-4 control-label">schedule_id</label>
		    <div class="col-sm-4">
		      ${feedingSchedule.schedule_id}
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="name" class="col-sm-4 control-label">feeding_time</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="feeding_time" name="feeding_time" placeholder="Name" value="${feedingSchedule.feeding_time}" required="required"/>
		    </div>
		  </div>

		  <div class="form-group">
		    <label for="food" class="col-sm-4 control-label">food </label>
		    <div class="col-sm-4">
		      <input type= "text" step="0.01" class="form-control" id="food" name="food" placeholder="food" value="${feedingSchedule.food}" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="notes" class="col-sm-4 control-label">notes</label>
		    <div class="col-sm-4">
		      <input type="text" step="0.01" class="form-control" id="notes" name="notes" placeholder="notes" value="${feedingSchedule.notes}" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="recurrence" class="col-sm-4 control-label">recurrence</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="recurrence" name="recurrence" placeholder="recurrence" value="${feedingSchedule.recurrence}" required="required"/>
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="animalid" class="col-sm-4 control-label">animalid</label>
		    <div class="col-sm-4">
		      ${feedingSchedule.animalID}
		    </div>
		  </div>
		  
	
		  <div class="form-group">
		    <div class="col-sm-offset-4 col-sm-1">
		      <button type="submit" class="btn btn-primary">Update</button>
		    </div>
		  </div>
		</form>
	  </div>
	</header>


	<!-- Footer -->
	<jsp:include page="footer.jsp" />