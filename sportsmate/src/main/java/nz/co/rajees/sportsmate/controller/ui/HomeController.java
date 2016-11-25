package nz.co.rajees.sportsmate.controller.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home.html")
public class HomeController {

	private int count = 0; 
	
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView printWelcome(ModelMap model){
        model.addAttribute("rajmessage", "You are so cool");
        List<String> warriorNames = new ArrayList<String>();
        warriorNames.add("Manu Vatuvei");
        warriorNames.add("Shaun Johnson");
        warriorNames.add("Konrad Hurrel");
        model.addAttribute("warrnames", warriorNames);
        if(count%2 ==0){
        	model.addAttribute("error", "There are " + count + " errors");
        }
        ModelAndView modelAndView = new ModelAndView("ui/home", model);
        count++;
        return modelAndView;
    }
}
