package nz.co.rajees.sportsmate.model;

import java.util.Date;
import java.util.List;

public class UserEvent {
	
	private String name;
	private String location;
	private Date start_date;
	private Date end_date;
	private List<EventTag> eventTags;
	
	public List<EventTag> getEventTags() {
		return eventTags;
	}
	public void setEventTags(List<EventTag> eventTags) {
		this.eventTags = eventTags;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
	
}
