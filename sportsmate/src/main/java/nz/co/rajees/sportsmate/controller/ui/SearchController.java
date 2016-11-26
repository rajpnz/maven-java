package nz.co.rajees.sportsmate.controller.ui;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ui/search.do")
public class SearchController {

	@RequestMapping(method=RequestMethod.POST)
	public String doSearch(HttpServletRequest servletRequest, ModelMap map){
		String isbn = servletRequest.getParameter("isbncode");
		String bookCat = servletRequest.getParameter("bookcategories");
		String error = "";
		if("-1".equals(bookCat)){
			error += "Book Category is mandatory ";
		}
		if(StringUtils.isEmpty(isbn)){
			error += "ISBN is mandatory ";
		}
		if(!StringUtils.isEmpty(error)){
			map.addAttribute("error", error);
			return "search.jsp";
		} else{
			return "redirect:../index.jsp";
		}
		
	}
}
