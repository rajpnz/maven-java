package nz.co.rajees.sportsmate.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * Catches exceptions in all Controllers
 * @see <a href="http://niels.nu/blog/2016/controller-advice-exception-handlers.html">
 *     Good controller advice link</a>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SportsMateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
	public String handleSportsMateException(SportsMateException ex){
        return ex.getMessage();
    }

    /**
     * This picks up validation exception picked up in the controllers
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleConstraintViolationException(ConstraintViolationException ex){
    	StringBuilder message = new StringBuilder();
    	for(ConstraintViolation c : ex.getConstraintViolations()){
    		message.append(c.getMessage());
    	}
        return message.toString();
    }


}
