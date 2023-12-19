package br.com.motiro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/pedidos")
	public String Pedidos() {
		return "/User/pedidos";
	}
	
	@GetMapping("/listas")
	public String Listas() {
		return "/User/listas";
	}
	
	@GetMapping("/pedidoso")
	public String pedodpsp() {
	return "/User/meusPedidosStatus";
	}
	
	@GetMapping("/eu")
	public String exibirInformacoes() {
	return "/User/minhasInformacoes";
	}
}
