
package com.example.hms;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.example.hms.service.UserService;
import com.example.hms.model.User;




@Controller
public class CustomerController{
	
	 @Autowired
	    private UserService userService;

	//static ArrayList<User> users=new ArrayList<>();
	@GetMapping("/")
	public String indexAction() {
		return "index";
	}
	@GetMapping("/register")
	public String signupAction(Model model) {
		
		 User user = new User();

	     model.addAttribute("user", user);
		//model.addAttribute("message", "Enter Your login Details");
		return "register";
	}
	
	//@Autowired
	//private UserRepository userRepository;
	@PostMapping("/register")
	public String signupActionProcess(@Valid User user, BindingResult bindingResult,Model model) {
		
		 User userExists = userService.findUserByEmail(user.getEmail());
	        if (userExists != null) {
	            bindingResult
	                    .rejectValue("email", "error.user",
	                            "There is already a user registered with the email provided");
	        }
	        if (!bindingResult.hasErrors()) {
	            
	            userService.saveUser(user);
	            model.addAttribute("successMessage", "User has been registered successfully");
	            model.addAttribute("user", new User());
	          

	        }
		return "register";
	}
	
		
 
}
