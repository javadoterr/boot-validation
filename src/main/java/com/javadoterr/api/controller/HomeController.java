package com.javadoterr.api.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javadoterr.api.entity.LoginData;

@Controller
public class HomeController {
	
	@GetMapping(path = "/")
	public String formPage(Model model) {
		model.addAttribute("loginData", new LoginData());
		
		return "form";
	}
	
	@PostMapping(path = "/process")
	public String processData(@Valid @ModelAttribute LoginData data,
										BindingResult result) {
		
		if(result.hasErrors()) {
			
			
			return "form"; // if error occurred then navigate to form page 
		}
		
		return "success";
	}

}
