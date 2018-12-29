
package com.example.hms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.hms.model.User;




@Controller
public class CustomerController{

	//static ArrayList<User> users=new ArrayList<>();
	@GetMapping("/")
	public String indexAction() {
		return "index";
	}
	@GetMapping("/register")
	public String signupAction(Model model) {
		//model.addAttribute("message", "Enter Your login Details");
		return "register";
	}
	
	@Autowired
	private UserRepository userRepository;
	@PostMapping("/register")
	public String signupActionProcess(@RequestParam String email
			, @RequestParam String password,Model model) {
		
		User n = new User();
		n.setEmail(email);
		n.setPassword(password);
		userRepository.save(n);
		
		model.addAttribute("message", "The user"+ email +" is signed up successfully");
		
		return "register";
	}
	
		
 
}
	
