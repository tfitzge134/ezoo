package com.feeding_schedules.model;

public class FeedingSchedule {
	private static int schedule_id ;
	private static String feeding_time="";
	private String recurrence="";
	private String food="";
	private String notes="";
	
	public static int getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		FeedingSchedule.schedule_id = schedule_id;
	}

	public static String getFeeding_time() {
		return feeding_time;
	}

	public void setFeeding_time(String feeding_time) {
		FeedingSchedule.feeding_time = feeding_time;
	}

	@Override
	public String toString() {
		return "Feeding_schedules [schedule_id=" + schedule_id + ", feeding_time=" + feeding_time + ", recurrence="
				+ recurrence + ", food=" + food + ", notes=" + notes + "]";
	}

	public String getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public FeedingSchedule() {
		
	}

	public FeedingSchedule(int schedule_id, String feeding_time, String recurrence, String food, String notes) {
		super();
		FeedingSchedule.schedule_id = schedule_id;
		FeedingSchedule.feeding_time = feeding_time;
		this.recurrence = recurrence;
		this.food = food;
		this.notes = notes;
	}

}
