package br.gov.sp.fatec.brasfut.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.brasfut.entity.Jogador;
import br.gov.sp.fatec.brasfut.entity.Usuario;
import br.gov.sp.fatec.brasfut.repository.JogadorRepository;
import br.gov.sp.fatec.brasfut.repository.UsuarioRepository;

@Service("fraseService")
public class JogadorServiceImpl implements JogadorService {

	@Autowired UsuarioRepository usuarioRepo;
	@Autowired JogadorRepository jogadorRepo;
	
	@Override
	@Transactional
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
	public Jogador AdicionarJogador(String nome,Date dataNasc, String time) {
		Usuario usuario = usuarioRepo.findTop1ByNomeOrEmail(time,time);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario com identificador "+time+"nao foi encontrado");
			
		}
		Jogador jogador =  new Jogador();
		jogador.setnome(nome);
		jogador.setDataNasc(dataNasc);
		jogador.setUsuario(usuario);
 
		jogadorRepo.save(jogador);
		return jogador;
	}

}
