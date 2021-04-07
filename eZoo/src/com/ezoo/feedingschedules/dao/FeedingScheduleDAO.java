package com.ezoo.feedingschedules.dao;


import java.util.List;

import com.ezoo.businessException.BusinessException;
import com.feeding_schedules.model.FeedingSchedule;

public interface FeedingScheduleDAO {
//A method to add a given feeding schedule
	//to the database.	
public int addFeedingSchedule(FeedingSchedule FeedingSchedule)
		throws BusinessException;

	
public int deleteById(int schedule_id);
//A method to retrieve all feeding schedules 
//from the database
/*
 * import com.examples.ezoo.model.Animal;
 */
public List<FeedingSchedule> 
getAllFeedingSchedule()throws BusinessException ;

//update
public void updateFeedingSchedule(FeedingSchedule FeedingScheduleToSave) throws Exception;
//A method to retrieve a single feeding schedule 
//from the database for a given animal
public FeedingSchedule getFeedingSchedule(int schedule_id)throws BusinessException;

//A method to assign a given feeding schedule to a given animal.
//update where animalid =feedingid;
public int assignFeedingSchedulet(int schedule_id, int animal_id)throws BusinessException;
//A method to remove a feeding schedule from a given animal.
public int removeFeedingSchedule(int schedule_id, int animal_id)throws BusinessException;
}

/*
 * You will need, at minimum:

A method to delete a given feeding schedule to the database.
 This method should first remove all references to that feeding 
 schedule from the ANIMALS table.
A method to retrieve all feeding schedules from the database
A method to retrieve a single feeding schedule 
from the database for a given animal
A method to assign a given feeding schedule to a given animal.
A method to remove a feeding schedule from a given animal.
 
 */
