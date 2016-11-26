package nz.co.rajees.sportsmate.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ui/search.do")
public class SearchController {

	@RequestMapping(method=RequestMethod.POST)
	public String doSearch(@RequestParam("isbncode") String isbn,
			@RequestParam("bookcategories") String bookCat, ModelMap map){
		String error = "";
		if("-1".equals(bookCat)){
			error += "Book Category is mandatory ";
		}
		if(StringUtils.isEmpty(isbn)){
			error += "ISBN is mandatory ";
		}
		if(!StringUtils.isEmpty(error)){
			map.addAttribute("error", error);
			map.addAttribute("isbncode", isbn);
			map.addAttribute("bookcategories", bookCat);
			return "search.jsp";
		} else{
			return "redirect:../index.jsp";
		}
		
	}
}
