package com.FamilyTree.sectionOne.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.FamilyTree.sectionOne.Service.RegisterService;


@Controller
public class AboutController {

	
	@Autowired
	private RegisterService registerService;
	
	
	public AboutController(RegisterService registerService) {
		super();
		this.registerService = registerService;
	}


	@GetMapping("/about")
	public String about() {
      return "about";
  }
	
	
	@GetMapping("/logout")
	public String logout() {
      return "/";
  }
}
