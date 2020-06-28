package br.com.almeida.springVingadores.model;

import org.springframework.stereotype.Component;

@Component
public class Vingador {

	private int id;
	private String nome;
	private String codiNome;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiNome() {
		return codiNome;
	}

	public void setCodiNome(String codiNome) {
		this.codiNome = codiNome;
	}

}
