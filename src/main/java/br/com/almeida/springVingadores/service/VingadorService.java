package br.com.almeida.springVingadores.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.almeida.springVingadores.model.Vingador;
import br.com.almeida.springVingadores.repository.VingadorRepository;

@Component
public class VingadorService {

	@Autowired
	VingadorRepository repository;

	@Autowired
	Vingador vingador;

	public String teste() {

		return "Teste ok... Seja bem vindo Vingador !";
	}

	public List<Vingador> listaDeVingadores() {

		return repository.getAllVingadores();
	}

	public int add(Vingador vingador) {

		return repository.add(vingador);

	}

	public Vingador buscarPorId(Long id) {

		return this.vingador = repository.finById(id);
	}

	public boolean delete(Long id) {

		return repository.delete(id);

	}

	public boolean atualizar(Vingador vingadorAtualizado, int id) {

		vingadorAtualizado.setId(id);

		return repository.atualizar(vingadorAtualizado);

	}
}
