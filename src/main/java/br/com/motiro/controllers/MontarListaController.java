package br.com.motiro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MontarListaController {

	@GetMapping("/montarAssai")
	public String montarAssai() {
	return "/catalogo/montarListaFe";
	}
}
