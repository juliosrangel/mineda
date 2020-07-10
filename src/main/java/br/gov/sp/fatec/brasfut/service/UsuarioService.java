package br.gov.sp.fatec.brasfut.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.brasfut.entity.Usuario;

public interface UsuarioService extends UserDetailsService{
	
	public Usuario novoUsuario(String nome,String email, String senha, String autorizacao);
	

}
