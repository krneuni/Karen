package sv.com.karen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("home")
@RequestMapping(value="/")
public class HomeController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String listar(Model model) {
		
		return "ver";
	}
}
