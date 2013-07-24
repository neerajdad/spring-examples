package uk.co.shivom.spring.example.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/hello", method=RequestMethod.GET)
public class HelloController {

	public String sayHello(ModelMap model) {
		model.addAttribute("message","Hi Neeraj, this is your test page");
		return "hello";
	}
	
}
