package br.gov.sp.fatec.brasfut;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import javax.xml.crypto.Data;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.brasfut.entity.Jogador;
import br.gov.sp.fatec.brasfut.entity.Usuario;
import br.gov.sp.fatec.brasfut.repository.JogadorRepository;
import br.gov.sp.fatec.brasfut.repository.UsuarioRepository;
import br.gov.sp.fatec.brasfut.service.JogadorService;
import br.gov.sp.fatec.brasfut.service.UsuarioService;

@SpringBootTest
@Transactional
@Rollback
class BrasfutApplicationTests {

	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private JogadorRepository jogadorRepo;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JogadorService jogadorService;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void usuarioRepositorySaveTest() {
		Usuario usuario = new Usuario();
		usuario.setNome("teste1");
		usuario.setEmail("email11@teste.com");
		usuario.setSenha("teste1");
		
		usuarioRepo.save(usuario);
		
		assertNotNull(usuario.getId());
	}

	@Test
	void jogadorRepositorySaveTest() {
		Usuario usuario = new Usuario();
		usuario.setNome("teste11");
		usuario.setEmail("email11@teste.com");
		usuario.setSenha("teste");
		
		usuarioRepo.save(usuario);
		
		Jogador jogador =  new Jogador();
		jogador.setnome("teste11");
		jogador.setDataNasc(new Date());
		jogador.setUsuario(usuario);

		jogadorRepo.save(jogador);
		assertNotNull(jogador.getId());
	}
	
	@Test
	void usuarioServiceNovoUsuarioTest() {
		Usuario usuario = usuarioService.novoUsuario( "king","king@test.com","king","admi");
		
		
		assertNotNull(usuario.getId());
	}
	
	@Test
	void JogadorServiceAdicionarJogadorTest() {
		usuarioService.novoUsuario("Teste1","teste1@email.com","Senha","ROLE_ADMIN");
		Jogador jogador = jogadorService.AdicionarJogador("Teste", new Date(), "Teste1");
		assertNotNull(jogador.getId());
	}

	

}
	
