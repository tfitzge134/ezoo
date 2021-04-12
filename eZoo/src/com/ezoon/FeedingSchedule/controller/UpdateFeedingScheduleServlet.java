package com.ezoon.FeedingSchedule.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezoo.businessException.BusinessException;
import com.ezoo.feedingschedules.dao.FeedingDAOUtilities;
import com.ezoo.feedingschedules.dao.FeedingScheduleDAO;
import com.ezoo.feedingschedules.dao.FeedingScheduleDAOImpl;
import com.feeding_schedules.model.FeedingSchedule;

/**
 * Servlet implementation class AddFeedingScheduleServlet
 */
@WebServlet("/updateFeedingSchedule")
public class UpdateFeedingScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * 
	
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
		int animalID = Integer.parseInt(request.getParameter("animalID"));
		
		FeedingScheduleDAO feedingScheduleDAO = new FeedingScheduleDAOImpl();
		try {
			FeedingSchedule feedingSchedule = feedingScheduleDAO.getFeedingSchedule(schedule_id, animalID);
			request.setAttribute("feedingSchedule", feedingSchedule);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("updateFeedingSchedule.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//We MUST convert to a Longsince parameters are always Strings
				int schedule_id = Integer.parseInt(request.getParameter("schedule_id"));
				String feeding_time = request.getParameter("feeding_time");
				String food = request.getParameter("food");
				String notes = request.getParameter("notes");
				String recurrence = request.getParameter("recurrence");
				long animalid = Long.parseLong(request.getParameter("animalID"));
				
				//Create an Feeding object from the parameters
				FeedingSchedule feedingSchedule = new FeedingSchedule();
				feedingSchedule.setSchedule_id(schedule_id);
				feedingSchedule.setFeeding_time(feeding_time);
				feedingSchedule.setFood(food);
				feedingSchedule.setNotes(notes);
				feedingSchedule.setRecurrence(recurrence);
				feedingSchedule.setAnimalID(animalid);

				//Call DAO method
				FeedingScheduleDAO dao = FeedingDAOUtilities.getFeedingScheduleDAO();
				try {
					dao.updateFeedingSchedule(feedingSchedule);
					request.getSession().setAttribute("message", "Feeding schedule updated");
					request.getSession().setAttribute("messageClass", "alert-success");
					response.sendRedirect("feedingSchedules"); 

				}catch (Exception e){
					e.printStackTrace();
					
					//change the message
					request.getSession().setAttribute("message", "There was a problem updating the feeding schedule at this time");
					request.getSession().setAttribute("messageClass", "alert-danger");
					
					request.getRequestDispatcher("updateFeedingSchedule.JSP").forward(request, response);

					
				}
				
	}	
}
