package com.FamilyTree.sectionOne.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.FamilyTree.sectionOne.Model.Register;
import com.FamilyTree.sectionOne.Service.RegisterService;

//import com.biedaalt.familyChat.Service.RegisterServiceImp;



@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	public RegisterController(RegisterService registerService) {
		super();
		this.registerService = registerService;
	}
	
	@GetMapping("/register")
	public String register() 
	{
//		Register user = new Register();
//		m.addAttribute("user", user);
		return "register";
	}
	
	@PostMapping("/register/save")
    public String processRegistration(@ModelAttribute Register user, 
    		BindingResult result, Model m) {
        // Process the registration (save user to the database, etc.)
        // You may want to perform validation, check if the username is unique, etc.
        // For simplicity, we assume UserRegistrationDto has "username" and "password" fields.

        // Redirect to login page after successful registration
		Register existingUser = registerService.findByEmail(user.getEmail());
		
		if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
			result.rejectValue("email",null, "Энэ имейл бүртгэгдсэн байна.");
		}
		if(result.hasErrors()) {
			m.addAttribute("user", user);
			return "register";
		}
	     
		
		this.registerService.addUser(user);
        return "redirect:/";
    }
	
	
//	@GetMapping("/home")
//    public String getAllUsers(Model model) {
//        List<RegisterDto> users = registerService.findAllUsers();
//        model.addAttribute("users", users);
//        return "homeS";
//    }
//	
//	@PostMapping("/register")
//	public String register(RegisterModel user){
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		String encodedPassword = passwordEncoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//		registerService.save(user);
//		return "register";
//	}
	
}
