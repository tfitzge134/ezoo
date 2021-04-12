package com.ezoon.FeedingSchedule.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezoo.feedingschedules.dao.FeedingDAOUtilities;
import com.ezoo.feedingschedules.dao.FeedingScheduleDAO;

/**
 * Servlet implementation class RemoveFeedingSchedule
 */
@WebServlet("/removeFeedingSchedule")
public class RemoveFeedingScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get Parameter from JSP Form
		long animalID = Long.parseLong(request.getParameter("animalID"));
		long schedule_id = Long.parseLong(request.getParameter("schedule_id"));

		FeedingScheduleDAO dao = FeedingDAOUtilities.getFeedingScheduleDAO();

		// Call DAO method
		try {

			dao.removeFeedingSchedule(schedule_id, animalID);

			request.getSession().setAttribute("message", "Feeding Schedule successfully deleted.");
			request.getSession().setAttribute("messageClass", "alert-success");

			request.getRequestDispatcher("feedingSchedules").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();

			// change the message
			request.getSession().setAttribute("message",
					"There was a problem deleting the feeding schedule at this time");
			request.getSession().setAttribute("messageClass", "alert-danger");

			request.getRequestDispatcher("feedingSchedules").forward(request, response);

		}
	}

}
