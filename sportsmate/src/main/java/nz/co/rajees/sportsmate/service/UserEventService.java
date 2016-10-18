package nz.co.rajees.sportsmate.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import nz.co.rajees.sportsmate.model.EventTag;
import nz.co.rajees.sportsmate.model.UserEvent;
import nz.co.rajees.sportsmate.utils.DateUtils;

@Component
public class UserEventService {

	public List<UserEvent> getEventsForUser(String id) {
		List<UserEvent> events = new ArrayList<UserEvent>();
		events.add(buildWimbledonUserEvent());
		events.add(buildNrlUserEvent());
		return events;
	}

	private UserEvent buildWimbledonUserEvent() {
		UserEvent userEvent1 = new UserEvent();
		userEvent1.setName("Wimbledon 2016");
		userEvent1.setLocation("London");
		LocalDate now = LocalDate.now();
		userEvent1.setStart_date(DateUtils.asDate(now));
		userEvent1.setEnd_date(DateUtils.asDate(now.plusDays(7)));
		EventTag federerTag = new EventTag("Roger Federer", "ATHLETE");
		EventTag tennisTag = new EventTag("Tennis", "SPORT");
		List<EventTag> tags = new ArrayList<EventTag>();
		//could use guava here
		tags.add(federerTag);
		tags.add(tennisTag);
		userEvent1.setEventTags(tags);
		return userEvent1;
	}

	private UserEvent buildNrlUserEvent() {
		UserEvent userEvent1 = new UserEvent();
		userEvent1.setName("NRL File 2016");
		userEvent1.setLocation("Sydney");
		LocalDate twoDaysAgo = LocalDate.now().minusDays(2);
		userEvent1.setStart_date(DateUtils.asDate(twoDaysAgo));
		userEvent1.setEnd_date(DateUtils.asDate(twoDaysAgo.plusDays(7)));
		EventTag johnsonTag = new EventTag("Shaun Johnson", "ATHLETE");
		EventTag leagueTag = new EventTag("Rugby League", "SPORT");
		List<EventTag> tags = new ArrayList<EventTag>();
		//could use guava here
		tags.add(johnsonTag);
		tags.add(leagueTag);
		userEvent1.setEventTags(tags);
		return userEvent1;
	}	
}
