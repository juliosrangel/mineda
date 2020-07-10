package br.gov.sp.fatec.brasfut.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import br.gov.sp.fatec.brasfut.controller.View;

@Entity
@Table(name = "jog_jogador")
public class Jogador {
	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name = "jog_id")
	 @JsonView(View.FraseCompleta.class)
	 private Long id;

	 @Column(name = "jog_nome", unique=true, length = 100, nullable = false)
	 @JsonView(View.FraseResumo.class)
	 private String nome;

	 @Column(name = "jog_data_nasc", nullable = false)
	 @JsonView(View.FraseCompleta.class)
	 private Date dataNasc;

	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "usr_time_id")
	 @JsonView(View.FraseResumo.class)
	 private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getnome() {
		return nome;
	}

	public void setnome(String nome) {
		this.nome = nome;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	 


}
