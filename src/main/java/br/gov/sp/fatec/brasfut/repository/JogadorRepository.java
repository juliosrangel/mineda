package br.gov.sp.fatec.brasfut.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import br.gov.sp.fatec.brasfut.entity.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

	@PreAuthorize("isAuthenticated()")
	public List<Jogador> findByNomeOrUsuarioEmail(String nome, String email);
}
