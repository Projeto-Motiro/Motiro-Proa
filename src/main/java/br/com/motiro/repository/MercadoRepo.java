package br.com.motiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.motiro.model.Mercado;

@Repository
public interface MercadoRepo extends JpaRepository<Mercado, Long> {

		
}
