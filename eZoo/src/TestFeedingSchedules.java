import java.util.List;

import com.ezoo.businessException.BusinessException;
import com.ezoo.feedingschedules.dao.FeedingScheduleDAO;
import com.ezoo.feedingschedules.dao.FeedingScheduleDAOImpl;
import com.feeding_schedules.model.FeedingSchedule;

public class TestFeedingSchedules {
	public static void main(String[] args) {
		
//		listFeedingSchedules();
//		System.out.println("----------");
//		addFeedingSchedule();
//		System.out.println("----------");
		updateFeedingSchedule();
		System.out.println("----------");
//		listFeedingSchedules();
//		 System.out.println("-----------");
//		 deleteFeedingSchedules();
//		 System.out.println("-----------");
//		 removeFeedingSchedule();
//		 getFeedingSchedule();
		
	}

	private static void addFeedingSchedule() {
		FeedingScheduleDAO dao = new FeedingScheduleDAOImpl();
		try {
			FeedingSchedule feedingScheduleX= 
					new FeedingSchedule(10, "Afternoon", "morning", "AAA", "nnn", 2);
			dao.addFeedingSchedule(feedingScheduleX);
			System.out.println("---DONE: addFeedingSchedule");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	private static void updateFeedingSchedule() {
		FeedingScheduleDAO dao = new FeedingScheduleDAOImpl();
		try {
			FeedingSchedule feedingSchedule = dao.getFeedingSchedule(12, 1);
			System.out.println("---BEFORE: update. FeedingSchedule: " + feedingSchedule);
			feedingSchedule.setFeeding_time("NooN");
			dao.updateFeedingSchedule(feedingSchedule);
			
			FeedingSchedule feedingSchedule2 = dao.getFeedingSchedule(12, 1);
			System.out.println("---AFTER: update. FeedingSchedule: " + feedingSchedule2);
			
			System.out.println("---DONE: updateFeedingSchedule");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	private static void deleteFeedingSchedules() {
		FeedingScheduleDAO dao1 = new FeedingScheduleDAOImpl();
		try {
			dao1.deleteById(1);
			System.out.println("---DONE: deleteById");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	private static void listFeedingSchedules() {
		FeedingScheduleDAO dao = new FeedingScheduleDAOImpl();
		List<FeedingSchedule> list;
		try {
			list = dao.getAllFeedingSchedule();
			for (int i = 0; i < list.size(); i++) {
				FeedingSchedule f = list.get(i);
				System.out.println(f);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}
	
	  private static void removeFeedingSchedule() {
		FeedingScheduleDAO dao1 = new FeedingScheduleDAOImpl();
		try {
			dao1.removeFeedingSchedule(2);
			System.out.println("---DONE: animal_id");
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	  private static void getFeedingSchedule() {
			FeedingScheduleDAO dao = new FeedingScheduleDAOImpl();
			try {

				dao.getFeedingSchedule(12, 1);
				System.out.println("---DONE: assignFeedingSchedule");
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}  

}
