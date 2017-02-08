package com.ddook.ddak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class DdookApplication {
	public static void main(String[] args) {
		SpringApplication.run(DdookApplication.class, args);
	}
	
	@RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Handlebars!");
        return "index";
    }
}
