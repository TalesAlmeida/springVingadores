package br.com.almeida.springVingadores.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.apache.catalina.filters.AddDefaultCharsetFilter.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

import br.com.almeida.springVingadores.model.Vingador;
import br.com.almeida.springVingadores.service.VingadorService;

@RestController
@RequestMapping("v1/vingadores")
public class VingadorController {
	@Autowired
	VingadorService vingadorService;

	@Autowired
	Vingador vingador;
	@Autowired
	List<Vingador> lista;

	ResponseEntity response = null;

	@GetMapping("/teste")
	public String teste() {

		return vingadorService.teste();
	}

	@GetMapping("/listar")
	public ResponseEntity<List<Vingador>> listaDeVingadores() {

		this.lista = vingadorService.listaDeVingadores();

		if (lista.size() > 0) {

			response = ResponseEntity.ok(lista);

		} else {

			response = ResponseEntity.notFound().build();
		}

		return response;
	}

	@GetMapping("/buscaporid/{id}")
	public ResponseEntity<Vingador> buscarporId(@PathVariable("id") Long id) {

		this.vingador = vingadorService.buscarPorId(id);

		if (this.vingador.getId() > 0) {

			response = ResponseEntity.ok(this.vingador);

		} else {

			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("msg: Não encontrado !");
		}

		return response;
	}

	@PostMapping("/vingador")
	public ResponseEntity newVingador(@RequestBody Vingador vingador) {

		int id = 0;
		id = vingadorService.add(vingador);

		if (id > 0) {
			response = ResponseEntity.status(HttpStatus.CREATED).body("Id: " + id);
		} else {
			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("msg: Erro ao tentar inserir !");
		}

		return response;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {

		if (vingadorService.delete(id)) {

			response = ResponseEntity.status(HttpStatus.OK).body("msg: Deletetado com sucesso !");

		} else {

			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("msg: Não encontrado !");
		}

		return response;
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity atualizar(@RequestBody Vingador vingadorAtualizado, @PathVariable("id") int id) {

		if (vingadorService.atualizar(vingadorAtualizado, id) == true) {

			response = ResponseEntity.status(HttpStatus.OK).body("msg: Atualizado com sucesso !");

		} else {

			response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("msg: Não encontrado !");

		}

		return response;

	}

}
