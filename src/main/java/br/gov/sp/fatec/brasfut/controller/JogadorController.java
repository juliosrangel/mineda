package br.gov.sp.fatec.brasfut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

//import br.gov.sp.fatec.brasfut.controller.View.FraseCompleta;
import br.gov.sp.fatec.brasfut.entity.Jogador;
import br.gov.sp.fatec.brasfut.repository.JogadorRepository;
import br.gov.sp.fatec.brasfut.service.JogadorService;

@RestController
@RequestMapping(value = "jogador")
@CrossOrigin
public class JogadorController {
	
	@Autowired
	private JogadorService jogadorService;
	
	@Autowired
	private JogadorRepository jogadorRepo;
	
	@PostMapping(value = "/novo")
	@JsonView(View.FraseCompleta.class)
	public Jogador cadastrarJogador(@RequestBody JogadorDTO jogador) {
		return jogadorService.AdicionarJogador(jogador.getNome(), jogador.getDataNasc(), jogador.getUsuario());
	}
	
	@GetMapping(value = "/busca/{time}")
	@JsonView(View.FraseCompleta.class)
	public List<Jogador> buscarPorNome(@PathVariable("time") String usuario){
		return jogadorRepo.findByNomeOrUsuarioEmail(usuario, usuario);
	}
}
