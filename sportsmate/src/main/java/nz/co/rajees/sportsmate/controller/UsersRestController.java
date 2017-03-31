package nz.co.rajees.sportsmate.controller;

import java.util.List;

import nz.co.rajees.sportsmate.controller.exception.SportsMateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import nz.co.rajees.sportsmate.model.UserEvent;
import nz.co.rajees.sportsmate.service.UserEventService;

import javax.validation.constraints.Size;

@RestController()
@Validated
public class UsersRestController {

	@Autowired
	private UserEventService userEventService;

	/**
	 * Uses Spring's validation framework see {@link nz.co.rajees.sportsmate.controller.exception.GlobalExceptionHandler}
	 * and {@link nz.co.rajees.sportsmate.spring.config.AppConfig}
	 */
	@GetMapping(value="/users/{id}/events")
	public List<UserEvent> listEventsForUser(@Size(min = 5) @PathVariable ("id") String id){
		if(true){
			throw new SportsMateException("testing 123");
		}
		List<UserEvent> result = userEventService.getEventsForUser(id);
		return result;
	}
}
