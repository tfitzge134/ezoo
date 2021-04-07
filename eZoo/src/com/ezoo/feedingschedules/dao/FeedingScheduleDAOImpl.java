package com.ezoo.feedingschedules.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.examples.ezoo.dao.DAOUtilities;
import com.ezoo.businessException.BusinessException;
import com.feeding_schedules.model.FeedingSchedule;

public class FeedingScheduleDAOImpl implements FeedingScheduleDAO{

	@Override
	public int addFeedingSchedule(FeedingSchedule feeding_schedules) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(int schedule_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FeedingSchedule> getAllFeedingSchedule() {

  List<FeedingSchedule>feeding_schedules = new ArrayList<>();
 
		
		Connection connection = null;
		Statement stmt = null;

		/*
		 * String sql = "SELECT * FROM ANIMALS";
public List<Animal> getAllAnimals() {
		List<Animal> animals = new ArrayList<>();
		Connection connection = null;
		Statement stmt = null;

			ResultSet rs = stmt.executeQuery(sql);

		 */
	
	  try {
			connection = FeedingDAOUtilities.getConnection();

			stmt = connection.createStatement();

			String sql = "SELECT * FROM public.Feeding_Schedules";

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				FeedingSchedule a = new FeedingSchedule();
				a.setSchedule_id(rs.getInt("schedule_id"));
				a.setFeeding_time(rs.getString("feeding_time"));
				a.setRecurrence(rs.getString("recurrence"));
				a.setFood(rs.getString("food"));
				a.setNotes(rs.getString("notes"));
				//a.setAnimalID(rs.getLong("animalid"));
/*
 * INSERT INTO public.feeding_schedules(
	schedule_id, feeding_time, recurrence, food, notes)
	VALUES (?, ?, ?, ?, ?);
 */
				
				feeding_schedules.add(a);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return feeding_schedules;	
	 
		
	}
	
		




	@Override
	public void updateFeedingSchedule(FeedingSchedule FeedingScheduleToSave) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		int success = 0;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "INSERT INTO public.feeding_schedules(\n"
					+ "	schedule_id, feeding_time, recurrence,"
					+ " food, notes)\n"
					+ "	VALUES (?, ?, ?, ?, ?);";

			// Setup PreparedStatement
			stmt = connection.prepareStatement(sql);

			// Add parameters from animal into PreparedStatement
			
			stmt.setInt(1, FeedingSchedule.getSchedule_id());
			stmt.setString(2, FeedingSchedule.getFeeding_time());
//			stmt.setString(2, animal.getName());
//
//			stmt.setString(3, animal.getTaxKingdom());
//			stmt.setString(4, animal.getTaxPhylum());
//			stmt.setString(5, animal.getTaxClass());
//			stmt.setString(6, animal.getTaxOrder());
//			stmt.setString(7, animal.getTaxFamily());
//			stmt.setString(8, animal.getTaxGenus());
//			stmt.setString(9, animal.getTaxSpecies());
//
//			stmt.setDouble(10, animal.getHeight());
//			stmt.setDouble(11, animal.getWeight());
//
//			stmt.setString(12, animal.getType());
//			stmt.setString(13, animal.getHealthStatus());
			
			success = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (success == 0) {
			// then update didn't occur, throw an exception
			throw new Exception("Insert  failed: " );
		}

	}

	@Override
	public FeedingSchedule getFeedingSchedule(int schedule_id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int assignFeedingSchedulet(int schedule_id, int animal_id) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeFeedingSchedule(int schedule_id, int animal_id) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

		
	}

	


