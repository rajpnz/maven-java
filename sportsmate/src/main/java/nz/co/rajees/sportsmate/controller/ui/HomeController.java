package nz.co.rajees.sportsmate.controller.ui;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home.html")
public class HomeController {

    @RequestMapping(method=RequestMethod.GET)
    public String printWelcome(ModelMap model){
        model.addAttribute("rajmessage", "You are so cool");
        List<String> warriorNames = new ArrayList<String>();
        warriorNames.add("Manu Vatuvei");
        warriorNames.add("Shaun Johnson");
        warriorNames.add("Konrad Hurrel");
        model.addAttribute("warrnames", warriorNames);
        return "ui/systemprops.jsp";
    }
}
