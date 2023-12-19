package br.com.motiro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("cep", "09876-543");
		return "/home/Index";
	}
	
	@GetMapping("/escolher")
	public String escolherMercado() {
	return "/home/escolherMercado";
	}
	
	@GetMapping("/sobre")
	public String sobreNos() {
	return "/home/quemSomos";
	}
	

}
