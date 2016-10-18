package nz.co.rajees.sportsmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nz.co.rajees.sportsmate.model.UserEvent;
import nz.co.rajees.sportsmate.service.UserEventService;

@RestController()
public class UsersRestController {

	@Autowired
	private UserEventService userEventService;
	
	@GetMapping(value="/users/{id}/events")
	public List<UserEvent> listEventsForUser(@PathVariable("id") String id){
		List<UserEvent> result = userEventService.getEventsForUser(id);
		return result;
	}
}
