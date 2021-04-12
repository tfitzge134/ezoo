package com.ezoo.feedingschedules.dao;

import java.util.List;

import com.ezoo.businessException.BusinessException;
import com.feeding_schedules.model.FeedingSchedule;

public interface FeedingScheduleDAO {

	/*
	 * You will need, at minimum:
	 */
//A method to delete a given feeding schedule to the database.
// This method should first remove all references to that feeding 
// schedule from the ANIMALS table.
	public int removeFeedingSchedule(long schedule_id, long animalID) throws BusinessException;

//A method to retrieve all feeding schedules from the database
//DONE
	public List<FeedingSchedule> getAllFeedingSchedule() throws BusinessException;

//A method to retrieve a single feeding schedule 
//from the database for a given animal
	public FeedingSchedule getFeedingSchedule(long schedule_id, long animalID) throws BusinessException;

//A method to assign a given feeding schedule to a given animal.
	// DONE
	//This method assigns a schedule to an animal
	public int addFeedingSchedule(FeedingSchedule feedingSchedule) throws BusinessException;


	//A method to update a given feeding schedule.
		public int updateFeedingSchedule(FeedingSchedule feedingSchedule) throws BusinessException;

//A method to remove a feeding schedule from a given animal.
	// DONE
	public int deleteById(long schedule_id) throws BusinessException;

}

/*
 * You will need, at minimum:
 * 
 * A method to delete a given feeding schedule to the database. This method
 * should first remove all references to that feeding schedule from the ANIMALS
 * table. A method to retrieve all feeding schedules from the database A method
 * to retrieve a single feeding schedule from the database for a given animal A
 * method to assign a given feeding schedule to a given animal. A method to
 * remove a feeding schedule from a given animal.
 * 
 */
