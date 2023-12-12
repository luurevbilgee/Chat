package com.FamilyTree.sectionOne.Controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.FamilyTree.sectionOne.Model.Messege;
import com.FamilyTree.sectionOne.Model.Register;
import com.FamilyTree.sectionOne.Service.MessageService;
import com.FamilyTree.sectionOne.Service.RegisterService;

@Controller
public class MessageController {
	
	private MessageService messegeService ;
	private RegisterService registerService;
	
	@Autowired
	public MessageController(MessageService messegeService, RegisterService registerService) {
		super();
		this.messegeService = messegeService;
		this.registerService = registerService;
	}

//	private List<String> messages = new ArrayList<>();

	    @GetMapping("/chat")
	    public String message(Model model ) {
	    	Collection<Messege> message = this.messegeService.getMessage();
	    	Collection<Register> email = this.registerService.getUsers();
			if(message !=null ) {
				model.addAttribute("message",message);
				model.addAttribute("users",email);
	      
			}
//			Collection<Register> user = registerService.getUsers();
//			if(user !=null ) {
//				model.addAttribute("user",user);
//			}
	        return "chat";
	    }
	    
	    

		@PostMapping("/send/message")
	    public String sendMessage( @ModelAttribute  Messege message, BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            // Handle validation errors, if needed
	            return "redirect:/chat";
	        }

	        this.messegeService.addMessege(message);
	        return "redirect:/chat";
	    }
}
