package br.gov.sp.fatec.brasfut.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.brasfut.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
	
	public Autorizacao findByNome(String nome);

}
