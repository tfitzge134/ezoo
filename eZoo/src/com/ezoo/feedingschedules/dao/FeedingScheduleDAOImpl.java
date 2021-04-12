package com.ezoo.feedingschedules.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ezoo.businessException.BusinessException;
import com.feeding_schedules.model.FeedingSchedule;

public class FeedingScheduleDAOImpl implements FeedingScheduleDAO {

	@Override
	public int deleteById(long schedule_id) throws BusinessException {
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = FeedingDAOUtilities.getConnection();

			stmt = connection.createStatement();
			String sql = "DELETE FROM public.feeding_schedules " + "WHERE schedule_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, schedule_id);
			int count = preparedStatement.executeUpdate();
			return count;
		} catch (Exception e) {
			// log.error(e);
			e.printStackTrace();
			throw new BusinessException("Internal error");
		}

	}

	@Override
	public List<FeedingSchedule> getAllFeedingSchedule() {

		List<FeedingSchedule> feeding_schedules = new ArrayList<>();

		Connection connection = null;
		Statement stmt = null;

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
				a.setAnimalID(rs.getLong("animalid"));

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
	public FeedingSchedule getFeedingSchedule(long schedule_id, long animalID) throws BusinessException {
		Connection connection = null;
		Statement stmt = null;
		FeedingSchedule feeding_schedules = null;

		try {
			connection = FeedingDAOUtilities.getConnection();

			stmt = connection.createStatement();
			String sql = "SELECT * FROM " + "public.feeding_schedules WHERE schedule_id = ? and animalid =?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, schedule_id);
			preparedStatement.setLong(2, animalID);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				feeding_schedules = new FeedingSchedule();
				feeding_schedules.setSchedule_id(resultSet.getInt("schedule_id"));
				feeding_schedules.setFeeding_time(resultSet.getString("feeding_time"));
				feeding_schedules.setRecurrence(resultSet.getString("recurrence"));
				feeding_schedules.setFood(resultSet.getString("food"));
				feeding_schedules.setNotes(resultSet.getString("notes"));
				feeding_schedules.setAnimalID(resultSet.getLong("animalid"));
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
	public int addFeedingSchedule(FeedingSchedule feedingSchedule) throws BusinessException {
		Connection connection = null;
		Statement stmt = null;
		int success = 0;

		try {
			connection = FeedingDAOUtilities.getConnection();

			stmt = connection.createStatement();
			String sql = "insert into feeding_schedules (schedule_id, animalid, "
					+ " feeding_time, recurrence, food, notes) values(?,?,?,?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, feedingSchedule.getSchedule_id());
			preparedStatement.setLong(2, feedingSchedule.getAnimalID());
			preparedStatement.setString(3, feedingSchedule.getFeeding_time());
			preparedStatement.setString(4, feedingSchedule.getRecurrence());
			preparedStatement.setString(5, feedingSchedule.getFood());
			preparedStatement.setString(6, feedingSchedule.getNotes());

			int count = preparedStatement.executeUpdate();
			return count;
		} catch (Exception e) {
			// log.error(e);
			e.printStackTrace();
			throw new BusinessException("Internal error");
		}

	}

	@Override
	public int removeFeedingSchedule(long schedule_id, long animalID) throws BusinessException {
		Connection connection = null;
		Statement stmt = null;

		try {
			connection = FeedingDAOUtilities.getConnection();

			stmt = connection.createStatement();
			String sql = "DELETE FROM public.feeding_schedules " + "WHERE animalid = ? AND schedule_id = ?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, animalID);
			preparedStatement.setLong(2, schedule_id);
			int count = preparedStatement.executeUpdate();
			return count;
		} catch (Exception e) {
			// log.error(e);
			e.printStackTrace();
			throw new BusinessException("Internal error");
		}

	}

	@Override
	public int updateFeedingSchedule(FeedingSchedule feedingSchedule) throws BusinessException {
		Connection connection = null;
		Statement stmt = null;
		int success = 0;

		try {
			connection = FeedingDAOUtilities.getConnection();

			stmt = connection.createStatement();
			String sql = "update feeding_schedules SET " + " feeding_time=?, recurrence=?, food=?, notes=?"
					+ " WHERE schedule_id=? AND animalid =?";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, feedingSchedule.getFeeding_time());
			preparedStatement.setString(2, feedingSchedule.getRecurrence());
			preparedStatement.setString(3, feedingSchedule.getFood());
			preparedStatement.setString(4, feedingSchedule.getNotes());

			preparedStatement.setLong(5, feedingSchedule.getSchedule_id());
			preparedStatement.setLong(6, feedingSchedule.getAnimalID());

			int count = preparedStatement.executeUpdate();
			return count;
		} catch (Exception e) {
			// log.error(e);
			e.printStackTrace();
			throw new BusinessException("Internal error");
		}
	}


}
