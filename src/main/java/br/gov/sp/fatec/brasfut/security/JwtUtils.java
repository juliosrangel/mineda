package br.gov.sp.fatec.brasfut.security;

import java.io.IOException;
import java.util.Date;

import org.springframework.security.core.userdetails.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.fatec.brasfut.controller.UsuarioDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtils {
	
	private static final String KEY = "spring.jwt.sec";

	public static String generateToken(User usuario) throws JsonProcessingException {
		 ObjectMapper mapper = new ObjectMapper();
		 UsuarioDTO usuarioSemSenha = new UsuarioDTO();
		 usuarioSemSenha.setNome(usuario.getUsername());
	 
		 if(!usuario.getAuthorities().isEmpty()) {
			 usuarioSemSenha.setAutorizacao(usuario.getAuthorities().iterator().next().getAuthority());
		 }
	 
		 String usuarioJson = mapper.writeValueAsString(usuarioSemSenha);
		 
		 Date agora = new Date();
		 
		 Long hora = 1000L * 60L * 60L; //gera numero correspondente a uma hora em milisegundos 
		 
		 return Jwts.builder().claim("userDetails", usuarioJson).setIssuer("br.gov.sp.fatec").setSubject(usuario.getUsername())
				 .setExpiration(new Date(agora.getTime() + hora)).signWith(SignatureAlgorithm.HS512, KEY).compact();
		 //jwt json web token
		 //issue é padrao jwt
	 }

	 
	 public static User parseToken(String token) throws JsonParseException, JsonMappingException, IOException {
	 ObjectMapper mapper = new ObjectMapper();
	 String credentialsJson = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody()
			 .get("userDetails", String.class);
	 
	 UsuarioDTO usuario = mapper.readValue(credentialsJson, UsuarioDTO.class);
	 
	 return (User) User.builder().username(usuario.getNome()).password("secret")
			 .authorities(usuario.getAutorizacao()).build();
	 }


}
