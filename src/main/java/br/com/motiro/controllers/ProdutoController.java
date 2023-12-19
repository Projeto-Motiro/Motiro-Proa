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

import br.com.motiro.model.Produto;
import br.com.motiro.repository.MercadoRepo;
import br.com.motiro.repository.ProdutoRepo;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepo produtoRepo;

	@Autowired
	private MercadoRepo mercadoRepo;

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("produto/listar");
		List<Produto> produtos = produtoRepo.findAll(); // Procurar metodo para comparar pesquisa com produtos no banco

		modelAndView.addObject("produtos", produtos);
		modelAndView.addObject("mercados", mercadoRepo.findAll());

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("produto/cadastro");
		modelAndView.addObject("produto", new Produto());
		modelAndView.addObject("mercados", mercadoRepo.findAll());
		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Produto produto, @RequestParam("fileProduto") MultipartFile file) throws IOException {

		try {
			produto.setImagem(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView("redirect:/produto");

		produtoRepo.save(produto);

		return modelAndView;
	}

	@GetMapping("/imagem/{id}")
	@ResponseBody
	public byte[] exibirImagen(@PathVariable("id") Long id) {
		Produto produto = this.produtoRepo.getReferenceById(id);
		return produto.getImagem();
	}
}
