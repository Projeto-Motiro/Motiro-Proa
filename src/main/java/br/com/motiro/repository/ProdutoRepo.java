package br.com.motiro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.motiro.model.Produto;

@Repository
public interface ProdutoRepo extends JpaRepository<Produto, Long> {

	List<Produto> findByCategoria(String categoria);

	List<Produto> findByNomeContainingIgnoreCase(String nome);
}
