import java.util.List;

import com.ezoo.businessException.BusinessException;
import com.ezoo.feedingschedules.dao.FeedingScheduleDAO;
import com.ezoo.feedingschedules.dao.FeedingScheduleDAOImpl;
import com.feeding_schedules.model.FeedingSchedule;

public class TestFeedingSchedules {
	public static void main(String[] args) throws BusinessException{
	    FeedingScheduleDAO dao = new FeedingScheduleDAOImpl();
	    List<FeedingSchedule> list = dao.getAllFeedingSchedule();

	    for (int i = 0; i < list.size(); i++){
	      FeedingSchedule f = list.get(i);
	      System.out.println(f);
	    }
	  }	

}



