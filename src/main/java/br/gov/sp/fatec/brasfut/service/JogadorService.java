package br.gov.sp.fatec.brasfut.service;

import java.util.Date;

import br.gov.sp.fatec.brasfut.entity.Jogador;

public interface JogadorService {

	public Jogador AdicionarJogador(String nome, Date dataNasc, String time);

	
	
}
