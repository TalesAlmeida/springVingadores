package br.com.almeida.springVingadores.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.almeida.springVingadores.model.Vingador;

@Repository
public class VingadorRepository {

	@Autowired
	Vingador vingador;
	private List<Vingador> vingadores;

	// Como não estamos trabalhando com banco de dados no momento, o construtor
	// inicializa a lista com o primeiro Vingador
	public VingadorRepository() {

		Vingador vingadorInicial = new Vingador();
		vingadores = new ArrayList<Vingador>();

		vingadorInicial.setId(1);
		vingadorInicial.setNome("Steve Rogers");
		vingadorInicial.setCodiNome("Capitão América");

		vingadores.add(vingadorInicial);
	}

	public List<Vingador> getAllVingadores() {

		return this.vingadores;
	}

	public int add(Vingador vingador) {

		vingador.setId(buscaUltimoIdInserido() + 1);

		this.vingadores.add(vingador);

		return buscaUltimoIdInserido();
	}

	public Vingador finById(Long id) {

		this.vingador = new Vingador();

		for (Vingador vingador : vingadores) {

			if (vingador.getId() == id) {
				this.vingador = vingador;
			}
		}

		return this.vingador;
	}

	public int buscaUltimoIdInserido() {

		int id = 0;

		id = vingadores.get(vingadores.size() - 1).getId();

		System.out.println("id inserido: " + id);

		return id;
	}

	public boolean delete(Long id) {

		this.vingador = finById(id);

		if (vingador.getId() > 0) {
			vingadores.remove(vingador);
			return true;
		} else {
			return false;
		}

	}

	public boolean atualizar(Vingador vingadorAtualizado) {

		boolean retorno = false;

		for (int i = 0; i < vingadores.size(); i++) {

			if (vingadores.get(i).getId() == vingadorAtualizado.getId()) {

				vingadores.set(i, vingadorAtualizado);

				retorno = true;

			}
		}

		System.out.println("retorno do Repository: " + retorno);

		return retorno;
	}

}
