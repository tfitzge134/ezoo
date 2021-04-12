package com.feeding_schedules.model;

public class FeedingSchedule {
	private long schedule_id;
	private String feeding_time = "";
	private String recurrence = "";
	private String food = "";
	private String notes = "";
	private long animalid;

	public FeedingSchedule() {

	}
	
	

	public FeedingSchedule(long schedule_id, String feeding_time, String recurrence, String food, String notes,
			long animalid) {
		super();
		this.schedule_id = schedule_id;
		this.feeding_time = feeding_time;
		this.recurrence = recurrence;
		this.food = food;
		this.notes = notes;
		this.animalid = animalid;
	}



	public long getAnimalid() {
		return animalid;
	}

	public void setAnimalid(long animalid) {
		this.animalid = animalid;
	}

	public long getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(long schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getFeeding_time() {
		return feeding_time;
	}

	public void setFeeding_time(String feeding_time) {
		this.feeding_time = feeding_time;
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

	public void setAnimalID(long animalid) {
		this.animalid = animalid;
	}

	public long getAnimalID() {
		return this.animalid;
	}

	@Override
	public String toString() {
		return "FeedingSchedule [schedule_id=" + schedule_id + ", feeding_time=" + feeding_time + ", recurrence="
				+ recurrence + ", food=" + food + ", notes=" + notes + ", animalid=" + animalid + "]";
	}

}
