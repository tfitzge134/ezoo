package com.ezoo.feedingschedules.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.examples.ezoo.dao.AnimalDAO;
//import com.examples.ezoo.dao.AnimalDaoImpl;

public class FeedingDAOUtilities {


		private static final String CONNECTION_USERNAME = "postgres";
		private static final String CONNECTION_PASSWORD = "Printer@2007";
		private static final String URL = "jdbc:postgresql://localhost:5432/eZoo";
		
		private static FeedingScheduleDAOImpl feeding_SchedulesDAOImpl;
		//private static AnimalDaoImpl animalDaoImpl;
		private static Connection connection;
    public static synchronized  FeedingScheduleDAO getFeedingScheduleDAO() {
		//public static synchronized AnimalDAO getAnimalDao() {
             if(feeding_SchedulesDAOImpl == null) {
            	 feeding_SchedulesDAOImpl = new FeedingScheduleDAOImpl();
			//if (animalDaoImpl == null) {
				//animalDaoImpl = new AnimalDaoImpl();
			}
			return feeding_SchedulesDAOImpl;
		}

		static synchronized Connection getConnection() throws SQLException {
			if (connection == null) {
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					System.out.println("Could not register driver!");
					e.printStackTrace();
				}
				connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
			}
			
			//If connection was closed then retrieve a new connection
			if (connection.isClosed()){
				System.out.println("getting new connection...");
				connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
			}
			return connection;
		}

	}


