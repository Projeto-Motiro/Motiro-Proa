package br.com.motiro.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.com.motiro.model.Mercado;
import br.com.motiro.repository.MercadoRepo;




@Controller
@RequestMapping("/mercado")
public class MercadoController {

	@Autowired
	private MercadoRepo mercadoRepo;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("mercado/listar");
		List<Mercado> mercados = mercadoRepo.findAll();
		modelAndView.addObject("mercados", mercados);
		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("mercado/cadastro");
		modelAndView.addObject("mercado", new Mercado());
		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Mercado mercado, @RequestParam("fileMercado") MultipartFile file) throws IOException {

		try {
			mercado.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/mercado");

		mercadoRepo.save(mercado);

		return modelAndView;
	}
	
	@GetMapping("/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long id) {
		Mercado mercado = this.mercadoRepo.getReferenceById(id);
		return mercado.getImagem();
	}
}
