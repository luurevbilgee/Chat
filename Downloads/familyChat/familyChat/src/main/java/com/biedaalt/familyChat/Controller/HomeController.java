package com.biedaalt.familyChat.Controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.biedaalt.familyChat.Model.Register;
import com.biedaalt.familyChat.Service.RegisterService;

@Controller
public class HomeController {

	@Autowired
//	private HomeService homeService;
	private RegisterService registerService;
	@Autowired
	public HomeController(RegisterService homeService) {
		super();
		this.registerService = homeService;
	}
	
	@GetMapping("/")
	public String home(Model m) {
		Collection<Register> users = this.registerService.getUsers();
		if(users !=null ) {
			m.addAttribute("user",users);
      
		}
		
		return "home";
  }
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		this.registerService.deleteUser(id);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model)
	{
		Register editUser = this.registerService.getUser(id);
		model.addAttribute("user",editUser);
		return "edit";
	}
	@PostMapping("/edit/update")
	public String updateStudent(@ModelAttribute Register user , 
    		BindingResult result, Model m)
	{
		Register existingUser = registerService.findByEmail(user.getEmail());
		
		if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email",null, "Энэ имейл бүртгэгдсэн байна.");
		}
		if(result.hasErrors()) {
			m.addAttribute("user", user);
			return "edit";
		}
		this.registerService.updateUser(user);
		return "redirect:/";
	}
	@GetMapping("/profile/{id}")
	public String viewStudent(@PathVariable Long id, Model model)
	{
		Register viewUser = this.registerService.getUser(id);
		model.addAttribute("user",viewUser);
		return "view";
	}
}
